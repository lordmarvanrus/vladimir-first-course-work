package pro.sky.vladimirfirstcoursework;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap();

    @Override
    public Employee addEmployee(String firstName, String lastName, int group, double salary) {
        Employee employee = new Employee(firstName, lastName, group, salary);
        if (!(employees.containsKey(firstName + lastName))) {
            employees.put(firstName + lastName, employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            employees.remove(firstName + lastName);
            return findEmployee(firstName, lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employees.values());
    }
}

