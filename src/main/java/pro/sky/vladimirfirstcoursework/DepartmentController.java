package pro.sky.vladimirfirstcoursework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getGroupMaxSalaryEmployee (@RequestParam ("departmentId") int group) {
        return departmentService.getGroupMaxSalaryEmployee(group);
    }

    @GetMapping ("/min-salary")
    public Employee getGroupMinSalaryEmployee (@RequestParam ("departmentId") int group) {
        return departmentService.getGroupMinSalaryEmployee(group);
    }

    @GetMapping (value = "/all", params = "departmentId")
    public List<Employee> getAllGroupEmployee (@RequestParam ("departmentId") int group) {
        return departmentService.getAllGroupEmployee(group);
    }

    @GetMapping ("/all")
    public Map<Integer, List<Employee>> getAllEmployee () {
        return departmentService.getAllEmployee();
    }
}
