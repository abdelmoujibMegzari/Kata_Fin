package org.example;

import java.util.HashSet;

public class Product extends AbstractPriceable {

    private final HashSet<Underlying> underlyings= new HashSet<>();
    private final HashSet<Client> clients = new HashSet<>();
    //I chose to store the list of clients and not only the  total ammount in case we want to implement latter modifications of cart

    public Product(String name,PorteFeuille porteFeuille){
        super(name);
        porteFeuille.add_Product(this);
    }

    protected void addClient(Client client){
        clients.add(client);
    }

    protected void addUnderlying(Underlying underlying){
        underlyings.add(underlying);
    }
    public float getPrice(){
        float totalPrice=0;
        for (Underlying underlying:
             underlyings) {
            totalPrice+=underlying.getPrice();
        }
        return totalPrice;
    }

    public int getAmount(){
        int totalAmount = 0;
        for (Client client:
             clients) {
            totalAmount+=client.getQuantity(this);
        }
        return totalAmount;
    }

}
