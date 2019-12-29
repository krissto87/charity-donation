package krissto87.charity.services;

import krissto87.charity.domain.entities.Category;
import krissto87.charity.dtos.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAllCategory();
}
