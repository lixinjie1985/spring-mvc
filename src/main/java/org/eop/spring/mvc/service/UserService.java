package org.eop.spring.mvc.service;

import java.util.List;

import org.eop.spring.mvc.bean.User;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
public interface UserService {

	Long saveUser(User user);
	
	User getUser(Long id);
	
	Long updateUser(User user);
	
	Long removeUser(Long id);
	
	List<User> listAllUsers();
}
