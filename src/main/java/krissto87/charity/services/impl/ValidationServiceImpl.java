package krissto87.charity.services.impl;

import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.services.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final UserRepository userRepository;

    @Override
    public Boolean isUniqueEmail(String email) {
        return !userRepository.existsByEmail(email);
    }
}
