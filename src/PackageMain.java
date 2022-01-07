import model.Client;
import model.Datasource;
import model.Parcel;

public class PackageMain {

    public static void main(String[] args) {

        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Couldn't open DB!");
            return;
        }


        Client client1 = new Client("Kris", "123");
        Client client2 = new Client("Pepi", "456");

        Parcel parcel = new Parcel(client1, client2, 6, Parcel.Destinations.OFFICE);

        datasource.insertParcel(parcel);
    }
}
