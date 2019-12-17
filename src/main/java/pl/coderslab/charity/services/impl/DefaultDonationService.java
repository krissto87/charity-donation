package pl.coderslab.charity.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.repository.DonationRepository;
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
}
