import model.Parcel;

import java.util.List;

public class OfficeWorker extends Employee{

    private List<Parcel> registeredParcelList; // всички пратки, регистрирани от служител

    public OfficeWorker(TypeOfEmployee typeOfEmployee, String name) {
        super(typeOfEmployee, name);
    }

    private void registerParcel(Parcel parcel){
        registeredParcelList.add(parcel);
    }
}
