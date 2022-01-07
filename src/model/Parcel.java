package model;

public class Parcel {
    //Крис

    private Client sender;
    private Client receiver;
    private double price;
    private final double weight;
    private String address;
    private final Destinations destination;

    public enum Destinations {
        OFFICE,
        ADDRESS
    }


    public Parcel(Client sender, Client receiver, double weight, Destinations destination) {
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.destination = destination;

        if(destination == Destinations.OFFICE) {
            System.out.println("Please chose office which you'd like the package to be delivered to: ");

            //Да се покаже лист от офиси
            this.address = "office";
            if(this.weight < 5){
                this.price = 5.6;
            } else {
                this.price = 5 + ((weight - 5) * 0.6);
            }

            System.out.println("The price of delivery is: " + this.price);
        } else {
            System.out.println("Please enter address for delivery: ");
//            this.address = scanner.nextLine();
             this.address = "address";
                if(this.weight < 5) {
                    this.price = 7;
                } else {
                    this.price = 7 + ((this.weight - 5) * 0.8);
                }
            System.out.println("The price of delivery is: " + this.price);
        }
    }

    public Client getSender() {
        return sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public Destinations getDestination() {
        return destination;
    }
}
