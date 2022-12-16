package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    static String otherThanQuote = " [^\"] ";
    static String quotedString = String.format(" \" %s* \" ", otherThanQuote);
    static String regex = String.format("(?x) " + // enable comments, ignore white spaces
                    ",                         " + // match a comma
                    "(?=                       " + // start positive look ahead
                    "  (?:                     " + //   start non-capturing group 1
                    "    %s*                   " + //     match 'otherThanQuote' zero or more times
                    "    %s                    " + //     match 'quotedString'
                    "  )*                      " + //   end group 1 and repeat it zero or more times
                    "  %s*                     " + //   match 'otherThanQuote'
                    "  $                       " + // match the end of the string
                    ")                         ", // stop positive look ahead
            otherThanQuote, quotedString, otherThanQuote);

    private static HashMap<String,Currency> read_forex(String forexFile) {
        HashMap<String,Currency> currencyHashMap=new HashMap<>();
        try (Scanner scanner = new Scanner(new File(forexFile));) {
            for(int i=0;i<5;i++) scanner.nextLine(); //Skip Commented lines TODO implement correctly
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] forex_line = line.split(regex);
                Currency currency = new Currency(forex_line[0], forex_line[1], Float.parseFloat(forex_line[2]
                        .replace("\"", "").replace(",", ".")));

                    currencyHashMap.put(currency.getName(),currency);
            }
            Currency eur = new Currency("EUR","EUR",1);
            currencyHashMap.put(eur.getName(), eur);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return currencyHashMap;
    }

    private static void read_prices(String pricesFiles,HashMap<String,PorteFeuille> porteFeuilleHashMap,HashMap<String,Product> productHashMap,HashMap<String,Currency> forex){
        try (Scanner scanner = new Scanner(new File(pricesFiles));) {
            for(int i=0;i<4;i++) scanner.nextLine(); //Skip Commented lines TODO emplement corrdctly
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] underlyingLine = line.split(regex);
                // getting the porteFeuille and creating it in case it doesn't exist
                PorteFeuille porteFeuille;
                if(porteFeuilleHashMap.containsKey(underlyingLine[0])){
                    porteFeuille =porteFeuilleHashMap.get(underlyingLine[0]);
                }else{
                    porteFeuille= new PorteFeuille(underlyingLine[0]);
                    porteFeuilleHashMap.put(porteFeuille.getName(),porteFeuille);
                }
                // getting the product and creating it in case it doesn't exist
                Product product;
                if(productHashMap.containsKey(underlyingLine[1])){
                    product =productHashMap.get(underlyingLine[1]);
                }else{
                    product= new Product(underlyingLine[1],porteFeuille);
                    productHashMap.put(product.getName(),product);
                }
                //getting currancy
                Currency currency;
                if(forex.containsKey(underlyingLine[3])) {
                    currency = forex.get(underlyingLine[3]);
                } else throw new RuntimeException("Currency not found: "+underlyingLine[3]);

                //creating a price
                Price price=new Price(Float.parseFloat(underlyingLine[4]
                        .replace("\"", "").replace(",", ".")),currency);
                //creating the underLying
                new Underlying(underlyingLine[2],product, price );
                //System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }

    }
    private static HashMap<String, Client> read_product(String pricesFiles, HashMap<String,Product> productHashMap){
        HashMap<String,Client> clientHashMap=new HashMap<>();
        try (Scanner scanner = new Scanner(new File(pricesFiles));) {
            for(int i=0;i<5;i++) scanner.nextLine(); //Skip Commented lines TODO implement correctly
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] underlyingLine = line.split(regex);
                // getting the porteFeuille and creating it in case it doesn't exist
                Client client;
                if(clientHashMap.containsKey(underlyingLine[1])){
                    client =clientHashMap.get(underlyingLine[1]);
                }else{
                    client= new Client(underlyingLine[1]);
                    clientHashMap.put(client.getName(),client);
                }
                // getting the product and creating it in case it doesn't exist
                Product product;
                if(productHashMap.containsKey(underlyingLine[0])){
                    product =productHashMap.get(underlyingLine[0]);
                }else{
                    throw new RuntimeException("product not found");
                }
                client.addToCart(product,Integer.parseInt(underlyingLine[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
        return clientHashMap;

    }


    public static void main(String[] args) {
        HashMap<String,Currency> forex = read_forex("resources/Forex.csv");
        HashMap<String,Product> productHashMap=new HashMap<>();
        HashMap<String,PorteFeuille> porteFeuilleHashMap=new HashMap<>();
        read_prices("resources/Prices.csv",porteFeuilleHashMap,productHashMap,forex);//modifies porteFeuilleHashMap and productHashMap
        HashMap<String,Client> clientHashMap =read_product("resources/Product.csv",productHashMap);
        PorteFeuille ptf1 =porteFeuilleHashMap.get("PTF1");
        System.out.println(ptf1.getName() + " " + ptf1.getPrice());
        Client client1 =clientHashMap.get("C8");
        System.out.println(client1.getName() +" "+client1.getPrice());





    }
}