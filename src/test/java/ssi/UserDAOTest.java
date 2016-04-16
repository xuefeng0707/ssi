package ssi;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import test.ssi.dao.UserDAO;
import test.ssi.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@Transactional(transactionManager = "txManager")
@Rollback(true)
public class UserDAOTest extends TestCase {
	
	@Resource
	private UserDAO userDAO;
	
	@Test
	public void getUserByUsername() {
		User user = userDAO.getUserByUsername("test");
		assertNotNull(user);
		assertEquals("test", user.getUsername());
	}
	
	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("test1");
		user.setPassword("test1");
		int count = userDAO.addUser(user);
		
		assertEquals(1, count);
	}
}
