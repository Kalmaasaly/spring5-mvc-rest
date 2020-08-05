package guru.springframework.spring5mvcrest.controllers.v1;

import guru.springframework.spring5mvcrest.api.v1.model.CustomerDTO;
import guru.springframework.spring5mvcrest.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    public static String FIRST_NAME = "firstname1";
    public static String LAST_NAME = "lastname1";
    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testListCategories() throws Exception {
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1l);
        customer1.setFirstName(FIRST_NAME);
        customer1.setLastName(LAST_NAME);
        CustomerDTO customer2 = new CustomerDTO();
        customer2.setFirstName(FIRST_NAME);
        customer2.setLastName(LAST_NAME);

        List<CustomerDTO> customers = Arrays.asList(customer1, customer2);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers",hasSize(2)));
    }
    @Test
    public void testCustomerByName() throws Exception {
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1l);
        customer1.setFirstName(FIRST_NAME);
        customer1.setLastName(LAST_NAME);
        when(customerService.getCustomerByFirstName(anyString())).thenReturn(customer1);

        mockMvc.perform(get("/api/v1/customers/Joe")
                .param("firstName",FIRST_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value((FIRST_NAME)));
    }

}