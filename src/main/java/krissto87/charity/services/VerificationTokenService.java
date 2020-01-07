package krissto87.charity.services;

import krissto87.charity.domain.entities.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);
}
