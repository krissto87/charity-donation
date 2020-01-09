package krissto87.charity.services;

import krissto87.charity.dtos.ChangePasswordDTO;
import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.dtos.UserProfileDTO;

public interface UserService {

    UserProfileDTO findUser();

    void updateUser(UserProfileDTO profile);

    void changeUserPassword(ChangePasswordDTO changePasswordDTO);

    Boolean sendEmailToResetPassword(String email);

    void changeUserPasswordAfterRemind(ChangePasswordDTO changePassword, String tokenUrl);
}
