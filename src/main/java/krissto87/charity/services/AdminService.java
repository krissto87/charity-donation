package krissto87.charity.services;


import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.EditAdminDTO;
import krissto87.charity.dtos.UserDTO;

import java.util.List;

public interface AdminService {

    List<AdminDTO> findAll();

    void save(AdminDTO admin);

    EditAdminDTO findUserById(Long id);

    void update(EditAdminDTO adminDTO);

    void deleteUserById(Long id);

    List<UserDTO> findAllUsers();
}
