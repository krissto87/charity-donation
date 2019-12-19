package krissto87.charity.services.impl;


import krissto87.charity.services.DonationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.entities.Donation;
import krissto87.charity.domain.repository.DonationRepository;
import krissto87.charity.dtos.AddDonationDTO;

@Service
@Transactional
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;

    public DefaultDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Long sumBagsFromAllDonations() {
        return  donationRepository.sumQuantities();
    }

    @Override
    public void saveDonation(AddDonationDTO donationDTO) {
        ModelMapper mapper = new ModelMapper();
        Donation donation = mapper.map(donationDTO, Donation.class);
        donationRepository.save(donation);
    }
}