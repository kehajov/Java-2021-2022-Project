import model.Parcel;

import java.util.List;

public class Courier extends Employee{

    public List<Parcel> listofParcelstoDeliver;

    public Courier(TypeOfEmployee typeOfEmployee, String name) {
        super(typeOfEmployee, name);
    }

    public void addParcel(Parcel parcel){
        listofParcelstoDeliver.add(parcel);
    }

    public List<Parcel> getListofParcelstoDeliver() {
        return listofParcelstoDeliver;
    }

    public void deliverParcel(Parcel parcel){
        listofParcelstoDeliver.remove(parcel);
    }
}
