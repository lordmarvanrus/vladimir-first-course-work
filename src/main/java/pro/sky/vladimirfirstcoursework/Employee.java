package pro.sky.vladimirfirstcoursework;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Employee {
    private final String firstName;
    private final String lastName;
    private final double salary;
    @JsonProperty("departmentId")
    private final int group;

    public Employee(String firstName, String lastName, int group, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.salary = salary;
    }
    public int getGroup() {
        return group;
    }
    public double getSalary() {
        return salary;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    @Override
    public String toString() {
        return "firstName: " + firstName + ", " + lastName;
    }
}
