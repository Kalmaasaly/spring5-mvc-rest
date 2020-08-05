package guru.springframework.spring5mvcrest.controllers.v1;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryListDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;

import guru.springframework.spring5mvcrest.api.v1.model.CustomerListDTO;
import guru.springframework.spring5mvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

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
}
