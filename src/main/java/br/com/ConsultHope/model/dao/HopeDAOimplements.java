package br.com.ConsultHope.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.ConsultHope.model.enitty.Hope;
import br.com.ConsultHope.model.mapper.ConsultRowMapper;

@Repository
public class HopeDAOimplements implements HopeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void create(Hope pacient) {
		
		
		String sql = "INSERT INTO consulthope.consult_pacient(name_pacient, exam, date_exam, result_exam)"
                + " VALUES (?, ?, ?, ?)"; 
		jdbcTemplate.update(sql, pacient.getName(), pacient.getExam(), pacient.getDateExam(),pacient.getResultExam());
	
		
	}

	@Override
	public List<Hope> getOrderAll() {
		
		  String sql = "SELECT * FROM consulthope.consult_pacient ORDER BY name_pacient,exam";
		  RowMapper<Hope> rowMapper = new ConsultRowMapper();
		  List<Hope> listExam = jdbcTemplate.query(sql , rowMapper);
		  return listExam;
	}

	@Override
	public void delete(int id) {
		
		  String sql = "DELETE FROM consulthope.consult_pacient WHERE id=?";
	      jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Hope getPacient(int id) {
		  
		  String sql = "SELECT * FROM consulthope.consult_pacient WHERE  id=?";
		  RowMapper<Hope> rowMapper = new ConsultRowMapper();
		  Hope hope = jdbcTemplate.queryForObject(sql, rowMapper, id);

		  return hope;
	}

	@Override
	public void update(Hope pacient, int id) {
		String sql = "UPDATE consulthope.consult_pacient SET name_pacient=?, exam=?, date_exam=?, result_exam=? WHERE  id=?";
		 jdbcTemplate.update(sql, pacient.getName(), pacient.getExam(), pacient.getDateExam(),pacient.getResultExam(),id);
		
	}


}
