package krissto87.charity.services;

import krissto87.charity.dtos.DonationDTO;

public interface DonationService {
    Long sumBagsFromAllDonations();

    void saveDonation(DonationDTO donationDTO);

    Long countOfInstitutionsWithDonations();
}
