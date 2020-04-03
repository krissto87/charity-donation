package krissto87.charity.services;

import krissto87.charity.dtos.CourierStatusDto;
import krissto87.charity.dtos.DonationDto;
import krissto87.charity.dtos.DonationDetailsDto;

import java.util.List;

public interface DonationService {
    Long sumBagsFromAllDonations();

    void saveDonation(DonationDto donationDTO);

    Long countOfInstitutionsWithDonations();

    List<DonationDto> findAllByUser(String username);

    CourierStatusDto findToSetStatusById(Long id);

    void confirmCourierVisit(CourierStatusDto statusDTO);

    DonationDetailsDto findById(Long id);
}

