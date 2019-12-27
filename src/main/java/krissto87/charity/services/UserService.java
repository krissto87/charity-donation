package krissto87.charity.services;

import krissto87.charity.dtos.UserDTO;

public interface UserService {
    UserDTO findUserByName(String username);

    void updateUser(UserDTO userDTO);
}
