package com.kb.driverslicenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.driverslicenses.models.License;
import com.kb.driverslicenses.repositories.LicenceRepository;

@Service
public class LicensesService {
    private final LicenceRepository licenseRepo;

    public LicensesService(LicenceRepository licenseRepo) {
        this.licenseRepo = licenseRepo;
    }

    public List<License> allLicenses(){
        return licenseRepo.findAll();
    }

    public License create(License license){
        return licenseRepo.save(license);
    }

    public License findLicense(Long id){
        Optional<License> optionalLicense = licenseRepo.findById(id);
        if(optionalLicense.isPresent()){
            return optionalLicense.get();
        } else {
            return null;
        }
    }

}
