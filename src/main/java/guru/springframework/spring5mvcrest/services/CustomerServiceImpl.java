package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.mapper.CustomerMapper;
import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;
import guru.springframework.spring5mvcrest.controllers.v1.CustomerController;
import guru.springframework.spring5mvcrest.domain.Customer;
import guru.springframework.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
        return customerRepository.
                findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDto(customer);
                    customerDTO.setCustomerUrl(getCustomerUrl(customer.getId()));
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    /*@Override
    public CustomerDTO getCustomerByFirstname(String firstName) {
        return customerMapper
                .customerToCustomerDto(customerRepository.findByFirstname(firstName));
    }*/
    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDto)
                .map(customerDTO -> {
                    //set API URL
                    customerDTO.setCustomerUrl(getCustomerUrl(id));
                    return customerDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        Customer saveCustomer1 = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDto(customer);
        returnDto.setCustomerUrl("api/v1/customers/" + saveCustomer1.getId());
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

    @Override
    public CustomerDTO patchCustomerDto(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if(customerDTO.getFirstname() !=null){
                customer.setFirstname(customerDTO.getFirstname());
            }
            if (customerDTO.getLastname() !=null){
                customer.setLastname(customerDTO.getLastname());
            }
            return customerMapper.customerToCustomerDto(customer);
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    private String getCustomerUrl(Long id) {
        System.out.println("id"+CustomerController.BASE_URL + "/" + id);
        return CustomerController.BASE_URL + "/" + id;
    }

}
