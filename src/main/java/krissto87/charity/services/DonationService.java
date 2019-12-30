package krissto87.charity.services;

import krissto87.charity.dtos.DonationDTO;

import java.util.List;

public interface DonationService {
    Long sumBagsFromAllDonations();

    void saveDonation(DonationDTO donationDTO);

    Long countOfInstitutionsWithDonations();

    List<DonationDTO> findAllByUser(String username);
}

