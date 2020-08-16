package guru.springframework.spring5mvcrest.controllers.v1;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.api.v1.model.CategoryListDTO;
import guru.springframework.spring5mvcrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO  getAllCategories(){
        return new CategoryListDTO(categoryService.getAllCategories());
    }
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(String name){
        return categoryService.getCategoryName(name);
    }
}
