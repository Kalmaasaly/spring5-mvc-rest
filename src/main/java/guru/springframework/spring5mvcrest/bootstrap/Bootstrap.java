package guru.springframework.spring5mvcrest.bootstrap;

import guru.springframework.spring5mvcrest.domain.Category;
import guru.springframework.spring5mvcrest.domain.Customer;
import guru.springframework.spring5mvcrest.repositories.CategoryRepository;
import guru.springframework.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository,CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository=customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("fruits");

        Category dried = new Category();
        dried.setName("dried");

        Category fresh = new Category();
        fresh.setName("fresh");

        Category nuts = new Category();
        nuts.setName("nuts");
        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);

        System.out.println("categoryRepository::::" + categoryRepository.count());


        Customer customer=new Customer();
        customer.setFirstName("firstname1");
        customer.setLastName("lastName1");

        Customer customer2=new Customer();
        customer2.setFirstName("firstname2");
        customer2.setLastName("lastName2");


        Customer customer3=new Customer();
        customer3.setFirstName("firstname3");
        customer3.setLastName("lastName3");

        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        System.out.println("customerRepository::::" + customerRepository.count());


    }
}
