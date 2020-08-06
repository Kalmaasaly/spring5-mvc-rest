package guru.springframework.spring5mvcrest.controllers.v1;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryListDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;

import guru.springframework.spring5mvcrest.api.v1.model.CustomerListDTO;
import guru.springframework.spring5mvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers(){
        return new ResponseEntity<>( new CustomerListDTO(customerService.getAllCustomers()),HttpStatus.OK);
    }
    @GetMapping("{firstName}")
    public ResponseEntity<CustomerDTO> getCustomerByFirstName(String firstName){
        return new ResponseEntity<CustomerDTO>(customerService.getCustomerByFirstName(firstName) ,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(customerService.createNewCustomer(customerDTO),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(customerService.saveCustomerDto(id,customerDTO),HttpStatus.OK);
    }

}
