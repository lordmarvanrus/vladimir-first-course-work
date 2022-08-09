package pro.sky.vladimirfirstcoursework;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getGroupMaxSalaryEmployee(int group) {
        return employeeService.getAllEmployee().stream()
                .filter(employee -> employee.getGroup() == group)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getGroupMinSalaryEmployee(int group) {
        return employeeService.getAllEmployee().stream()
                .filter(employee -> employee.getGroup() == group)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllGroupEmployee(int group) {
        return employeeService.getAllEmployee().stream()
                .filter(employee -> employee.getGroup() == group)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployee() {
        return employeeService.getAllEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getGroup));
    }
}
