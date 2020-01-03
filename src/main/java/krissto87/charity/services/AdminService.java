package krissto87.charity.services;


import krissto87.charity.dtos.AdminDTO;

import java.util.List;

public interface AdminService {
    List<AdminDTO> findAll();
}
