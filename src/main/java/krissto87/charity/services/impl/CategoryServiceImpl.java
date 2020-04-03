package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.Category;
import krissto87.charity.dtos.CategoryDto;
import krissto87.charity.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDto> findAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(c->mapper.map(c, CategoryDto.class)).collect(Collectors.toList());
    }
}
