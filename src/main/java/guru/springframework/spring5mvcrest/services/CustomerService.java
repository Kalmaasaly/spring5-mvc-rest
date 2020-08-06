package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;
import guru.springframework.spring5mvcrest.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByFirstName(String firstname);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
    CustomerDTO saveCustomerDto(Long id,CustomerDTO customerDTO);
    CustomerDTO patchCustomerDto(Long id,CustomerDTO customerDTO);
}
