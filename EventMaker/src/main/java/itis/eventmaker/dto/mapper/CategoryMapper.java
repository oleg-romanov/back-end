package itis.eventmaker.dto.mapper;

import itis.eventmaker.dto.in.CategoryDto;
import itis.eventmaker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    @Autowired
    UserMapper userMapper;

    public CategoryDto toCategoryDtoConvert(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
