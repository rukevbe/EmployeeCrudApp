package com.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.employee.model.Employees;
import com.employee.service.EmployeeService;

@Component
public  class EmployeeFormValidator implements Validator {
	
	
	@Override
	 public boolean supports(Class clazz) {
        return Employees.class.isAssignableFrom(clazz);
    }
	
	@Override
	public void validate(Object target, Errors errors) {


		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.firstname","First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "error.surname","surname is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.address","address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email","email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone","error.phone", "phone numberis required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date_of_birth", "error.date_of_birth","date of birth is required.");
		ValidationUtils.rejectIfEmpty(errors, "gender", "error.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.salary","salary is required.");

		

		

	}
}
