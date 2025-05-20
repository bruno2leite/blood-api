package com.brunoleite.bloodapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunoleite.bloodapi.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	Optional<Patient> findByCpf(String cpf);
}
