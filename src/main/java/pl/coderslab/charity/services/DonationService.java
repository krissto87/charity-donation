package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.AddDonationDTO;

public interface DonationService {
    Long sumBagsFromAllDonations();

    void saveDonation(AddDonationDTO donationDTO);
}
