package br.com.ConsultHope.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ConsultHope.model.enitty.Hope;

@Service
public interface ConsultService {
	
	 public List<Hope> getAllExams();
	 
	 public Hope findExams(int id);

	 public void creatPacient(Hope hope) throws ParseException;
		 
	 public void deletePacient(int id);
	 
	 public  void updatePacient(Hope hope, int id);
	 
	

}