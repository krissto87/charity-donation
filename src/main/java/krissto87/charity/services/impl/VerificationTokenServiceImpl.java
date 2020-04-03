package krissto87.charity.services.impl;

import krissto87.charity.domain.entities.User;
import krissto87.charity.domain.entities.VerificationToken;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.domain.repository.VerificationTokenRepository;
import krissto87.charity.services.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@Slf4j
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository tokenRepository;
    private final UserRepository userRepository;

    public VerificationTokenServiceImpl(VerificationTokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Boolean isTokenValidToActiveUser(String tokenUrl) {
        VerificationToken token = tokenRepository.findByToken(tokenUrl);
        boolean validTokenTime = LocalDateTime.now().isBefore(token.getExpiryDate());
        log.debug("Token is valid {}", validTokenTime);
        if (validTokenTime) {
            User user = userRepository.getOne(token.getUser().getId());
            user.setActive(Boolean.TRUE);
            userRepository.save(user);
            log.debug("User after token activation: {}", user);
            return true;
        }
        log.info("Token not found in database or expired!");
        return false;
    }

    @Override
    public Boolean isTokenValidToRemindPassword(String tokenUrl) {
        VerificationToken token = tokenRepository.findByToken(tokenUrl);
        boolean validTokenTime = LocalDateTime.now().isBefore(token.getExpiryDate());
        log.debug("Token is valid {}", validTokenTime);
        return validTokenTime;
    }
}
