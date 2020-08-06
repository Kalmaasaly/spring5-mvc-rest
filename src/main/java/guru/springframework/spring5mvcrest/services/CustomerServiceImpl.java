package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.mapper.CustomerMapper;
import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;
import guru.springframework.spring5mvcrest.domain.Customer;
import guru.springframework.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByFirstName(String firstName) {
        return customerMapper
                .customerToCustomerDto(customerRepository.findByFirstName(firstName));
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        Customer saveCustomer1 = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDto(customer);
        returnDto.setCustomerUrl("api/v1/customer/" + saveCustomer1.getId());
        return returnDto;

    }

    @Override
    public CustomerDTO saveCustomerDto(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);
        Customer customer1= customerRepository.save(customer);
        CustomerDTO customerDTO1=customerMapper.customerToCustomerDto(customer1);
        customerDTO1.setCustomerUrl("api/v1/customers/" + customer1.getId());
        return customerDTO;
    }
}
