package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
}
