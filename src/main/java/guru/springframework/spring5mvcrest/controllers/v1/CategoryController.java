package guru.springframework.spring5mvcrest.controllers.v1;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CategoryListDTO;
import guru.springframework.spring5mvcrest.services.CategoryService;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getAllCategories(){
        return new ResponseEntity<>(
                new CategoryListDTO(categoryService.getAllCategories()),HttpStatus.OK);
    }
    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(String name){
        return new ResponseEntity<CategoryDTO>(categoryService.getCategoryName(name),HttpStatus.OK);
    }
}
