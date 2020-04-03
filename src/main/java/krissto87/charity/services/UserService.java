package krissto87.charity.services;

import krissto87.charity.dtos.ChangePasswordDto;
import krissto87.charity.dtos.UserProfileDto;

public interface UserService {

    UserProfileDto findUser();

    void updateUser(UserProfileDto profile);

    void changeUserPassword(ChangePasswordDto changePasswordDTO);

    Boolean sendEmailToResetPassword(String email);

    void changeUserPasswordAfterRemind(ChangePasswordDto changePassword, String tokenUrl);
}
