package krissto87.charity.services;


public interface VerificationTokenService {
    Boolean isTokenValidToActiveUser(String tokenUrl);

    Boolean isTokenValidToRemindPassword(String tokenUrl);
}
