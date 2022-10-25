package rikkei.academy.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.Customer;
import rikkei.academy.model.Province;
import rikkei.academy.service.IGenerateService;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer>findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    boolean existsByFirstName(String firstName);
}
