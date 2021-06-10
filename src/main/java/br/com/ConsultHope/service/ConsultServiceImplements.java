package br.com.ConsultHope.service;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.ConsultHope.model.dao.HopeDAO;
import br.com.ConsultHope.model.enitty.Hope;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsultServiceImplements implements ConsultService{
	
	
	@Autowired
	HopeDAO hopeDao ;
	
	@Override
	public List<Hope> getAllExams() {
		
		return hopeDao.getOrderAll();
	}

	@Override
	public Hope findExams(int id) {
	
		return hopeDao.getPacient(id);
	}

	@Override
	public void creatPacient(Hope hope) throws ParseException {
		hopeDao.create(hope);
		
	}

	@Override
	public void deletePacient(int id) {
		
		hopeDao.delete(id);
	}

	@Override
	public void updatePacient(Hope hope, int id) {
		hopeDao.update(hope, id);
		
	}
	
}
