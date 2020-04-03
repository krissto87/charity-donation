package krissto87.charity.services;


import krissto87.charity.dtos.AdminDto;
import krissto87.charity.dtos.DeleteAdminDto;
import krissto87.charity.dtos.EditAdminDto;
import krissto87.charity.dtos.EditUserDto;

import java.util.List;

public interface AdminService {

    List<AdminDto> findAllAdmins();

    void save(AdminDto admin);

    EditAdminDto findAdminById(Long id);

    void updateAdmin(EditAdminDto adminDTO);

    void deleteAdminById(Long id);

    List<EditUserDto> findAllUsers();

    EditUserDto findUserById(Long id);

    void updateUser(EditUserDto userDTO);

    void deleteUserById(Long id);

    void blockUserById(Long id);

    void activateUserById(Long id);

    DeleteAdminDto findAdminToDeleteById(Long id);
}
