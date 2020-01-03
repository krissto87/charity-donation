package krissto87.charity.services;

import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.UserDTO;
import krissto87.charity.dtos.UserProfileDTO;

public interface UserService {
    UserProfileDTO findUserByName(String username);

    void updateUser(UserDTO user);

    void changeUserPassword(String username, String password);

    void save(AdminDTO admin);
}
