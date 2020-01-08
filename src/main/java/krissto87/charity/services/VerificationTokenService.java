package krissto87.charity.services;


public interface VerificationTokenService {
    Boolean makeUserActive(String tokenUrl);

    Boolean prepareResetPasswordPage(String tokenUrl);
}
