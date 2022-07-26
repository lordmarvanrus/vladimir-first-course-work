package pro.sky.vladimirfirstcoursework;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName, @RequestParam ("lastName") String lastName){
        Employee employee = employeeService.addEmployee(firstName, lastName);
        return employee;
    }
    @RequestMapping("/remove")
    public Employee removeEmployee (@RequestParam("firstName") String firstName, @RequestParam ("lastName") String lastName){
        Employee employee = employeeService.findEmployee(firstName, lastName);
        employeeService.removeEmployee(firstName, lastName);
        return employee;

    }
    @RequestMapping("/find")
    public Employee findEmployee (@RequestParam("firstName") String firstName, @RequestParam ("lastName") String lastName){
        Employee employee = employeeService.findEmployee(firstName, lastName);
        employeeService.findEmployee(firstName, lastName);
        return employee;
    }
    @RequestMapping("/list")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
    }
}
