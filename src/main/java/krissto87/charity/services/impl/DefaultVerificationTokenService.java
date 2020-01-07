package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.VerificationToken;
import krissto87.charity.domain.repository.VerificationTokenRepository;
import krissto87.charity.services.VerificationTokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultVerificationTokenService implements VerificationTokenService {

    private final VerificationTokenRepository tokenRepository;

    public DefaultVerificationTokenService(VerificationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public VerificationToken findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
