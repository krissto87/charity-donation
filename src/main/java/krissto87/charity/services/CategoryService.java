package krissto87.charity.services;

import krissto87.charity.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
}
