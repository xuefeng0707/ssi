package test.ssi.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import test.ssi.model.User;

@Repository
public class UserDAO {
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	public User getUserByUsername(String username) {
		return sqlSession.selectOne("UserDAO.getUserByUsername", username);
	}
	
	public int addUser(User user) {
		return sqlSession.insert("UserDAO.addUser", user);
	}
}
