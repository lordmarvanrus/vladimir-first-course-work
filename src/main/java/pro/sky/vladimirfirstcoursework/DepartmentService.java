package pro.sky.vladimirfirstcoursework;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getGroupMaxSalaryEmployee(int group);

    Employee getGroupMinSalaryEmployee(int group);

    List<Employee> getAllGroupEmployee(int group);

    Map<Integer, List<Employee>> getAllEmployee();
}
