package com.vaccination.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccination.model.Vaccination;


@Repository
public interface VaccinationRepo extends JpaRepository<Vaccination, Integer> {

}
