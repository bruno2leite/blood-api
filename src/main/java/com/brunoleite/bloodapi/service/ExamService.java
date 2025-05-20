package com.brunoleite.bloodapi.service;

import com.brunoleite.bloodapi.dto.ExamDataDTO;
import com.brunoleite.bloodapi.model.Exam;
import com.brunoleite.bloodapi.model.Patient;
import com.brunoleite.bloodapi.repository.ExamRepository;
import com.brunoleite.bloodapi.repository.PatientRepository;

//import com.brunoleite.bloodapi.repository.PatientRepository;
import org.springframework.stereotype.Service;
@Service
public class ExamService {
	private final ExamRepository examRepository;
	private final PatientRepository patientRepository;
	
	public ExamService(ExamRepository examRepository, PatientRepository patientRepository) {
		this.examRepository = examRepository;
		this.patientRepository = patientRepository;
	}
	
	public Exam saveExam(ExamDataDTO data) {
		Patient patient = patientRepository.findByCpf(data.cpf).orElseGet(() -> {
			Patient p = new Patient();
			p.setCpf(data.cpf);
			p.setName(data.name);
			return patientRepository.save(p);
		});
		
		Exam exam = new Exam();
		exam.setDate(data.date);
		exam.setHemoglobin(data.hemoglobin);
		exam.setLeukocytes(data.leukocytes);
		exam.setPlatelets(data.platelets);
		exam.setPatient(patient);
		
		return examRepository.save(exam);
	}
	
}
