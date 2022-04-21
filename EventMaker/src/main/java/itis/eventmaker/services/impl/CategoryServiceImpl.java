package itis.eventmaker.services.impl;

import itis.eventmaker.model.Category;
import itis.eventmaker.repositories.CategoryRepository;
import itis.eventmaker.services.CategoryService;
import itis.eventmaker.utils.ResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl extends ResponseCreator implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createDefaultCategories() {
        String [] categoryNames = {"Друзья", "Родственники", "Коллеги", "Животные"};
        for (int i = 0; i < categoryNames.length; i++) {
            Optional<Category> category0 = categoryRepository.findByName(categoryNames[i]).stream().findFirst();
            if (category0.isPresent()) {
                continue;
            }
            Category category = Category.builder()
                    .name(categoryNames[i])
                    .build();
            categoryRepository.save(category);
        }
    }
}
