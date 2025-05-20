package com.brunoleite.bloodapi.service;


import org.springframework.stereotype.Service;

import com.brunoleite.bloodapi.dto.ExamDataDTO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

@Service
public class PdfService {
	public ExamDataDTO extractData(InputStream inputStream) throws IOException{
		PDDocument document = PDDocument.load(inputStream);
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(document);
		document.close();
		
		ExamDataDTO dto = new ExamDataDTO();
		for(String line : text.split("\\n")) {
			if(line.contains("Nome:")) dto.name = line.split(":")[1].trim();
			else if (line.contains("CPF:")) dto.cpf = line.split(":")[1].trim();
			else if(line.contains("Data")) dto.date = LocalDate.parse(line.split(":")[1].trim());
			else if (line.contains("Hemoglobina:")) dto.hemoglobin = Double.parseDouble(line.split(":")[1].trim());
            else if (line.contains("Leucócitos:")) dto.leukocytes = Double.parseDouble(line.split(":")[1].trim());
            else if (line.contains("Plaquetas:")) dto.platelets = Double.parseDouble(line.split(":")[1].trim());
		}
		
		return dto;
	}
	
}
