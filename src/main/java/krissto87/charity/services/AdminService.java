package krissto87.charity.services;


import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.DeleteAdminDTO;
import krissto87.charity.dtos.EditAdminDTO;
import krissto87.charity.dtos.EditUserDTO;

import java.util.List;

public interface AdminService {

    List<AdminDTO> findAllAdmins();

    void save(AdminDTO admin);

    EditAdminDTO findAdminById(Long id);

    void updateAdmin(EditAdminDTO adminDTO);

    void deleteAdminById(Long id);

    List<EditUserDTO> findAllUsers();

    EditUserDTO findUserById(Long id);

    void updateUser(EditUserDTO userDTO);

    void deleteUserById(Long id);

    void blockUserById(Long id);

    void activateUserById(Long id);

    DeleteAdminDTO findAdminToDeleteById(Long id);
}
