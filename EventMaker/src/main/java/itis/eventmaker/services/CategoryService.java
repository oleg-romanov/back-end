package itis.eventmaker.services;

import itis.eventmaker.dto.in.CategoryDto;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity createCategory(String authorization, CategoryDto categoryDto);
    ResponseEntity updateCategoryById(String authorization, CategoryDto categoryDto, long id);
    ResponseEntity getAllCategories(String authorization);
    ResponseEntity deleteCategoryById(String authorization, long id);
    ResponseEntity getCategoryById(String authorization, long id);
    void createDefaultCategories();
}