package br.com.ConsultHope.model.dao;

import java.util.List;

import br.com.ConsultHope.model.enitty.Hope;


public interface HopeDAO {
	
	public void create (Hope pacient);
	
	public List<Hope> getOrderAll();
	
	public void delete(int id);
	
	public Hope getPacient(int id);
	
	public void update(Hope pacient, int id);
	
	
	

}
