package rikkei.academy.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rikkei.academy.model.Customer;
import rikkei.academy.service.customer.ICustomerService;

public class ValidateUserName implements Validator{
    @Autowired
    ICustomerService customerService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        Iterable<Customer> listCustomer = customerService.findAll();
        Customer customer = (Customer) target;
        for(Customer c: listCustomer){
            if (c.getFirstName().equals(customer.getFirstName())){
                errors.rejectValue("firstName","firstName.datontai");
                break;
            }
        }

    }
}
