package ru.teamscore.java23.csvsimple;


public class Customer {
    private String firstName;
    private String lastName;

    private int age;

    private RainfallType rainfall;

    public Customer() {

    }

    public Customer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RainfallType getRainfall() {
        return rainfall;
    }

    public void setRainfall(RainfallType rainfall) {
        this.rainfall = rainfall;
    }

    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}