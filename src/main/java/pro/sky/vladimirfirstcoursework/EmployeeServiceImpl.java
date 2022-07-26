package pro.sky.vladimirfirstcoursework;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(firstName, employees.get(i).getFirstName())
                    && Objects.equals(lastName, employees.get(i).getLastName())) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        employees.remove(findEmployee(firstName, lastName));
        return findEmployee(firstName, lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee;
        for (int i = 0; i < employees.size(); i++) {
            if (!(employees.get(i) != null
                    && Objects.equals(firstName, employees.get(i).getFirstName())
                    && Objects.equals(lastName, employees.get(i).getLastName()))) {
            }
            employee = employees.get(i);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public List<Employee> getAllEmployee(){
        return new ArrayList<>(employees);
    }
}
