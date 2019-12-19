package krissto87.charity.services;

import krissto87.charity.dtos.AddDonationDTO;

public interface DonationService {
    Long sumBagsFromAllDonations();

    void saveDonation(AddDonationDTO donationDTO);
}
