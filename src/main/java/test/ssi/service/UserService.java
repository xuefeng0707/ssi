package test.ssi.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import test.ssi.dao.UserDAO;
import test.ssi.model.User;

@Service
public class UserService {

	@Resource
	private UserDAO userDAO;
	
	public User getUserByUsername(String username) {
		if(StringUtils.isEmpty(username)) {
			return null;
		}
		
		return userDAO.getUserByUsername(username);
	}
}
