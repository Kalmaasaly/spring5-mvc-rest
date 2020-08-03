package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.mapper.CategoryMapper;
import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.domain.Category;
import guru.springframework.spring5mvcrest.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class CategoryServiceImplTest {

    public static final Long ID=2L;
    public  static final String NAME="Jimmy";
    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService=new CategoryServiceImpl(CategoryMapper.INSTANCE,categoryRepository);
    }

    @Test
    void getAllCategories() {
        List<Category> categories= Arrays.asList(new Category(),new Category(),new Category());

        when(categoryRepository.findAll()).thenReturn(categories);


        //when
        List<CategoryDTO> categoryDTOS=categoryService.getAllCategories();

        assertEquals(3,categoryDTOS.size());
    }

    @Test
    void getCategoryName() {

        //given
        Category category =new Category();
        category.setName(NAME);
        category.setId(ID);

        when(categoryRepository.findByName(anyString())).thenReturn(category);


        CategoryDTO categoryDTO=categoryService.getCategoryName(NAME);
        //then
        assertEquals(Long.valueOf(ID),categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());
    }


}