package krissto87.charity.services.impl;

import krissto87.charity.services.DonationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.entities.Donation;
import krissto87.charity.domain.repository.DonationRepository;
import krissto87.charity.dtos.DonationDTO;

@Service
@Transactional
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;
    private final ModelMapper mapper;

    public DefaultDonationService(DonationRepository donationRepository, ModelMapper mapper) {
        this.donationRepository = donationRepository;
        this.mapper = mapper;
    }

    @Override
    public Long sumBagsFromAllDonations() {
        return  donationRepository.sumQuantities();
    }

    @Override
    public void saveDonation(DonationDTO donationDTO) {
        Donation donation = mapper.map(donationDTO, Donation.class);
        donationRepository.save(donation);
    }

    @Override
    public Long countOfInstitutionsWithDonations() {
        return donationRepository.countOfInstitutionWithDonation();
    }
}
