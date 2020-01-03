package krissto87.charity.services;


import krissto87.charity.dtos.InstitutionDTO;

import java.util.List;

public interface AdminService {
    List<InstitutionDTO> findAll();
}
