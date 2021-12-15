import java.util.Scanner;

public class Package {
    //Крис

    Scanner scanner = new Scanner(System.in);

    private Client sender;
    private Client receiver;
    private final double weight;
    private Destination destination;
    private double price;
    private String address;


    public Package(Client sender, Client receiver, double weight, Destination destination) {
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.destination = Destination.OFFICE;

        if(destination == Destination.OFFICE) {
            System.out.println("Please chose office which you'd like the package to be delivered to: ");

            //Да се покаже лист от офиси

            if(this.weight < 5){
                this.price = 5.6;
            } else {
                this.price = 5 + ((weight - 5) * 0.6);
            }

            System.out.println("The price of delivery is: " + this.price);
        } else {
            System.out.println("Please enter address for delivery: ");
            this.address = scanner.nextLine();
                if(this.weight < 5) {
                    this.price = 7;
                } else {
                    this.price = 7 + ((this.weight - 5) * 0.8);
                }
            System.out.println("The price of delivery is: " + this.price);
        }
    }


}
