package com.analysis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.analysis.common.Status;
import com.analysis.entity.Role;
import com.analysis.entity.User;


@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findByUserId(String userId);

	public User findByUserIdAndStatus(String userId, Status status);
	
	public Iterable<User> findByStatus(Status status);
	
	public Iterable<User> findByRoleAndStatus(Role role, Status status);
		
	public Iterable<User> findByRoleAndStatusAndUserIdStartingWith(Role role, Status status, String userId);
	


	public User findByEmailId(String emailId);

	public Iterable<User> findByRole(Role role);

}
