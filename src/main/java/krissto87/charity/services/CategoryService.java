package krissto87.charity.services;

import krissto87.charity.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAllCategory();
}
