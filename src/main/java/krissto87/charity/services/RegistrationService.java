package krissto87.charity.services;

import krissto87.charity.dtos.RegistrationDataDTO;

import javax.validation.Valid;

public interface RegistrationService {
    void register(@Valid  RegistrationDataDTO registrationData);

}
