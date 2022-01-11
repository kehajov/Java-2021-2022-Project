package model;

public class Client {
    //Димана

    private String name;
    private String phone;
    public List <Parcel> listOfSentParcels;
    public List <Parcel> listOfReceivedParcels;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
        listOfReceivedParcels = new ArrayList();
        listOfSentParcels = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public List<Parcel> getListOfSentParcels() {
        return listOfSentParcels;
    }

    public List<Parcel> getListOfReceivedParcels() {
        return listOfReceivedParcels;
    }
    
    public void addSentParcel (Parcel sentParcel){listOfSentParcels.add(sentParcel);}
    public void addReceivedParcel (Parcel receivedParcel){listOfReceivedParcels.add(receivedParcel);}

    public void displaySentParcels() {
        if (listOfSentParcels.isEmpty()) {
            System.out.println("There aren't any sent parcels.");
        } else {
            Iterator<Parcel> iterator = listOfSentParcels.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next() + " ");
            }
        }
    }

    public void displayReceivedParcels() {
        if (listOfReceivedParcels.isEmpty()) {
            System.out.println("There aren't any received parcels.");
        } else {
            Iterator<Parcel> iterator = llistOfReceivedParcels.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next() + " ");
            }
        }
    }
}
