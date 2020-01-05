package krissto87.charity.services;


import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.EditAdminDTO;

import java.util.List;

public interface AdminService {

    List<AdminDTO> findAll();

    void save(AdminDTO admin);

    EditAdminDTO findUserById(Long id);

    void update(EditAdminDTO adminDTO);
}
