package com.kb.driverslicenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.driverslicenses.models.License;

@Repository
public interface LicenceRepository extends CrudRepository<License, Long> {
    List<License> findAll();
}
