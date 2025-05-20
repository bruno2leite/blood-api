package com.brunoleite.bloodapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.brunoleite.bloodapi.dto.ExamDataDTO;
import com.brunoleite.bloodapi.model.Exam;
import com.brunoleite.bloodapi.service.ExamService;
import com.brunoleite.bloodapi.service.PdfService;

import java.io.IOException;

@RestController
@RequestMapping("/exams")
public class ExamController {
	
	private final PdfService pdfService;
	private final ExamService examService;
	
	public ExamController(PdfService pdfService, ExamService examService) {
		this.pdfService = pdfService;
		this.examService = examService;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadExam(@RequestParam("file") MultipartFile file) throws IOException{
		ExamDataDTO data = pdfService.extractData(file.getInputStream());
		Exam savedExam = examService.saveExam(data);
		return ResponseEntity.ok("Exam saved successfully. Exam ID: " + savedExam.getId());
	}
}
