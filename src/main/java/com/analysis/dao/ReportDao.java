package com.analysis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.entity.Reportdata;


@Transactional
public interface ReportDao extends CrudRepository<Reportdata, Long> {

	public List<Reportdata> findByItemname(String itemname);

	public List<Reportdata> findByItemnameAndItemcategory(String itemname, String itemcategory);

	//public Reportdata findByitemnameAndrating1 (String itemname, rating1 rating1);
	
	//public Iterable<Reportdata> itemcategory (String itemcategory);
	
	//public Iterable<Reportdata> findByRoleAndStatus(Role role, rating1 rating1);
		
	//public Iterable<Reportdata> findByrating1AnditemnameAndUserIdStartingWith(Role role, rating1 status, String userId);
	


	//public User findByEmailId(String emailId);

	//public Iterable<User> findByRole(Role role);

}
