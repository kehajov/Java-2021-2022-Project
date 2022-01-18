public class Employee {
    private final TypeOfEmployee typeOfEmployee;
    private final String name;

    public enum TypeOfEmployee {
        COURIER,OFFICEWORKER
    }

    public Employee(TypeOfEmployee typeOfEmployee, String name) {
        this.typeOfEmployee = typeOfEmployee;
        this.name = name;
    }

    public TypeOfEmployee getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public String getName() {
        return name;
    }
}
