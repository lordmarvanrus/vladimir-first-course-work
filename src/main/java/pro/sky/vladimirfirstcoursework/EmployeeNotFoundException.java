package pro.sky.vladimirfirstcoursework;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class EmployeeNotFoundException extends RuntimeException{
}
