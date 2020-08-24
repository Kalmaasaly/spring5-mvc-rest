package guru.springframework.spring5mvcrest.bootstrap;

import guru.springframework.spring5mvcrest.domain.Category;
import guru.springframework.spring5mvcrest.domain.Customer;
import guru.springframework.spring5mvcrest.domain.Vendor;
import guru.springframework.spring5mvcrest.repositories.CategoryRepository;
import guru.springframework.spring5mvcrest.repositories.CustomerRepository;
import guru.springframework.spring5mvcrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository=customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();


    }

    private void loadVendors() {
        Vendor vendor=new Vendor();
        vendor.setName("vendor");

        Vendor vendor2=new Vendor();
        vendor2.setName("vendor2");

        Vendor vendor3=new Vendor();
        vendor3.setName("vendor3");

        Vendor vendor4=new Vendor();
        vendor4.setName("vendor4");

        Vendor vendor5=new Vendor();
        vendor3.setName("vendor5");

        vendorRepository.save(vendor);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
        vendorRepository.save(vendor4);
        vendorRepository.save(vendor5);

        System.out.println("vendorRepository::::" + vendorRepository.count());


    }

    private void loadCustomers() {
        Customer customer=new Customer();
        customer.setFirstname("firstname1");
        customer.setLastname("lastName1");

        Customer customer2=new Customer();
        customer2.setFirstname("firstname2");
        customer2.setLastname("lastName2");


        Customer customer3=new Customer();
        customer3.setFirstname("firstname3");
        customer3.setLastname("lastName3");

        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        System.out.println("customerRepository::::" + customerRepository.count());
    }

    private void loadCategories() {
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
    }
}
