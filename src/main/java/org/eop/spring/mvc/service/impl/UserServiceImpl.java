package org.eop.spring.mvc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eop.spring.mvc.bean.User;
import org.eop.spring.mvc.service.UserService;
import org.eop.spring.mvc.utils.IdUtils;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
public class UserServiceImpl implements UserService {

	private static final Map<Long, User> USERS = new HashMap<>();
	
	static {
		for (int i = 0; i < 0; i++) {
			Long id = IdUtils.getRandomUserId();
			USERS.put(id, new User(id, "lixinjie" + i, "000000", new Date()));
		}
	}
	
	@Override
	public Long saveUser(User user) {
		user.setId(IdUtils.getRandomUserId());
		user.setRegisterTime(new Date());
		USERS.put(user.getId(), user);
		return user.getId();
	}

	@Override
	public User getUser(Long id) {
		return USERS.get(id);
	}

	@Override
	public Long updateUser(User user) {
		User ouser = USERS.get(user.getId());
		ouser.setUserName(user.getUserName());
		ouser.setPassword(user.getPassword());
		return user.getId();
	}

	@Override
	public Long removeUser(Long id) {
		USERS.remove(id);
		return id;
	}

	@Override
	public List<User> listAllUsers() {
		return new ArrayList<>(USERS.values());
	}

}
