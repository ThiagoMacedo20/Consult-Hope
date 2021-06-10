package br.com.ConsultHope.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.ConsultHope.model.enitty.Hope;


public class ConsultRowMapper implements RowMapper < Hope > {
	
  

		@Override
	       public Hope mapRow(ResultSet rs, int rowNum) throws SQLException {
	           Hope hope = new Hope();
	           hope.setId(rs.getInt("id"));
	           hope.setName(rs.getString("name_pacient"));
	           hope.setExam(rs.getString("exam"));
	           hope.setDateExam(rs.getString("date_exam"));
	           hope.setResultExam(rs.getString("result_exam"));

	           return hope;
	       }

}
