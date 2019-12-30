package krissto87.charity.services.impl;

import krissto87.charity.domain.repository.CategoryRepository;
import krissto87.charity.domain.repository.InstitutionRepository;
import krissto87.charity.domain.repository.UserRepository;
import krissto87.charity.services.DonationService;
import krissto87.charity.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import krissto87.charity.domain.entities.Donation;
import krissto87.charity.domain.repository.DonationRepository;
import krissto87.charity.dtos.DonationDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public DefaultDonationService(DonationRepository donationRepository, UserRepository userRepository,
                                  InstitutionRepository institutionRepository, CategoryRepository categoryRepository, ModelMapper mapper) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public Long sumBagsFromAllDonations() {
        return  donationRepository.sumQuantities();
    }

    @Override
    public void saveDonation(DonationDTO donationDTO) {
        log.debug("DonationDTO {}", donationDTO);
        Donation donation = new Donation();
        donation.setQuantity(donationDTO.getQuantity());
        donation.setInstitution(institutionRepository.getById(donationDTO.getInstitutionId()));
        donation.setCategories(categoryRepository.findAllById(donationDTO.getCategoriesId()));
        donation.setStreet(donationDTO.getStreet());
        donation.setCity(donationDTO.getCity());
        donation.setZipCode(donationDTO.getZipCode());
        donation.setPickUpDate(donationDTO.getPickUpDate());
        donation.setPickUpTime(donationDTO.getPickUpTime());
        donation.setPickUpComment(donationDTO.getPickUpComment());
        donation.setDonor(userRepository.findUserByEmail(SecurityUtils.getUsername()));
        log.debug("Donor: {}", donation.getDonor());
        donation.setCreateTime(LocalDateTime.now());
        log.debug("Donation object before save {}", donation);
        donationRepository.save(donation);
    }

    @Override
    public Long countOfInstitutionsWithDonations() {
        return donationRepository.countOfInstitutionWithDonation();
    }

    @Override
    public List<DonationDTO> findAllByUser(String username) {
        List<Donation> donations = donationRepository.findAllWithUser(username);
        log.debug("Donations by User: {}", donations);
        return donations.stream().map(d-> mapper.map(d, DonationDTO.class)).collect(Collectors.toList());
    }
}
