package krissto87.charity.services;

import krissto87.charity.dtos.CourierStatusDTO;
import krissto87.charity.dtos.DonationDTO;
import krissto87.charity.dtos.DonationDetailsDTO;

import java.util.List;

public interface DonationService {
    Long sumBagsFromAllDonations();

    void saveDonation(DonationDTO donationDTO);

    Long countOfInstitutionsWithDonations();

    List<DonationDTO> findAllByUser(String username);

    CourierStatusDTO findToSetStatusById(Long id);

    void confirmCourierVisit(CourierStatusDTO statusDTO);

    DonationDetailsDTO findById(Long id);
}

