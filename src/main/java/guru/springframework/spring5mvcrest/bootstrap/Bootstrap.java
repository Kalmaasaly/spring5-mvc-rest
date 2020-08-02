package guru.springframework.spring5mvcrest.bootstrap;

import guru.springframework.spring5mvcrest.domain.Category;
import guru.springframework.spring5mvcrest.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits=new Category();
        fruits.setName("fruits");

        Category dried=new Category();
        dried.setName("dried");

        Category fresh=new Category();
        fresh.setName("fresh");

        Category nuts=new Category();
        nuts.setName("nuts");
        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);

        System.out.println("categoryRepository::::"+categoryRepository.count());


    }
}
