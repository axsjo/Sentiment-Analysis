package com.analysis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.common.Status;
import com.analysis.entity.Role;



@Transactional
public interface RoleDao extends CrudRepository<Role, Long> {

	public Role findByName(String name);
	
	public Iterable<Role> findByStatus(Status status);

}
