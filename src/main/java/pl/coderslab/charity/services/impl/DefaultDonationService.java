package pl.coderslab.charity.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.dtos.AddDonationDTO;
import pl.coderslab.charity.services.DonationService;

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
