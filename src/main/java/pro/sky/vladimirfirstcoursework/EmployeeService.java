package pro.sky.vladimirfirstcoursework;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int group, double salary);

    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
    List<Employee> getAllEmployee();
}
