package krissto87.charity.services;

import krissto87.charity.dtos.RegistrationDataDto;

import javax.validation.Valid;

public interface RegistrationService {
    void register(@Valid RegistrationDataDto registrationData);

}
