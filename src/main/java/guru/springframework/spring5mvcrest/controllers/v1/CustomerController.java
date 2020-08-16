package guru.springframework.spring5mvcrest.controllers.v1;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryListDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;

import guru.springframework.spring5mvcrest.api.v1.model.CustomerListDTO;
import guru.springframework.spring5mvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers(){
        return new CustomerListDTO(customerService.getAllCustomers());
    }
    /*@GetMapping("/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerByFirstName(String firstName){
        return customerService.getCustomerByFirstname(firstName) ;
    }*/
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createNewCustomer(customerDTO);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerDto(id,customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }


}
