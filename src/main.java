import model.Parcel;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("testing if branch is working");

        //testing class Employee - Veronika

        Courier nikolai = new Courier (Employee.TypeOfEmployee.COURIER,"Nikolai");
        System.out.println(nikolai.getName() + nikolai.getTypeOfEmployee());
    }
}
