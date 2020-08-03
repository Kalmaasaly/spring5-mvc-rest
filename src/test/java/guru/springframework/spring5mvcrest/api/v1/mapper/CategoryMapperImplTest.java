package guru.springframework.spring5mvcrest.api.v1.mapper;

import guru.springframework.spring5mvcrest.api.v1.model.CategoryDTO;
import guru.springframework.spring5mvcrest.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperImplTest {


    public static final String NAME="Joe";
    public static final Long ID=1L;
    CategoryMapper categoryMapper=CategoryMapper.INSTANCE;



    @Test
    void categoryToCategoryDto() {

        //given
        Category category =new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO=categoryMapper.categoryToCategoryDto(category);

        //then
        assertEquals(Long.valueOf(ID),categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());
    }
}