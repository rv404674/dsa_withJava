package classes.ch7;

class Employee {

    /**
     * NOTE: Access Modifiers Type
     * public - can be access anywhere from the code
     * private - can only be accessed through its own data members
     * protected - is involved in case of inheritance.
     * default - applies when no modifier is present. can only be accessed in the same package
     */

    public String name;
    private int salary;

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getSalary() {
        return this.salary;
    }
}

public class AccessModifiersBasics {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setSalary(20);
        System.out.println(employee.getSalary());
    }

}
