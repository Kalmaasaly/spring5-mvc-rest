package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.mapper.CustomerMapper;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;
import guru.springframework.spring5mvcrest.bootstrap.Bootstrap;
import guru.springframework.spring5mvcrest.domain.Customer;
import guru.springframework.spring5mvcrest.repositories.CategoryRepository;
import guru.springframework.spring5mvcrest.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.not;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerServiceImplIT {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    CustomerService customerService;


    @BeforeEach
    void setUp() throws Exception {
        Bootstrap bootstrap=new Bootstrap(categoryRepository,customerRepository);
        bootstrap.run();

         customerService=new CustomerServiceImpl(CustomerMapper.INSTANCE,customerRepository);

    }
    @Test
    public void patchCustomerUpdateFirstName(){
        String updatedName="updatedName";
        long id=getCustomerIdValue();
        Customer originalCustomer=customerRepository.findById(id).get();
        //-------
        String originalFirstName=originalCustomer.getFirstname();
        String originalLastName=originalCustomer.getLastname();

        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setFirstname(updatedName);

        customerService.patchCustomerDto(id,customerDTO);

        Customer updatedCustomer=customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName,updatedCustomer.getFirstname());
        assertThat(originalFirstName, not(equalTo(updatedCustomer.getFirstname())));
        assertThat(originalLastName, equalTo(updatedCustomer.getLastname()));


    }
    @Test
    public void patchCustomerUpdateLastName(){
        String updatedName="updatedName";
        long id=getCustomerIdValue();
        Customer originalCustomer=customerRepository.findById(id).get();
        //-------
        String originalFirstName=originalCustomer.getFirstname();
        String originalLastName=originalCustomer.getLastname();

        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setLastname(updatedName);

        customerService.patchCustomerDto(id,customerDTO);

        Customer updatedCustomer=customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName, updatedCustomer.getLastname());
        assertThat(originalLastName, not(equalTo(updatedCustomer.getLastname())));
        assertThat(originalFirstName, equalTo(updatedCustomer.getFirstname()));
    }

    public Long getCustomerIdValue(){
        List<Customer> customers=customerRepository.findAll();
        System.out.println("size"+customers.size());
        return customers.get(0).getId();
    }
}