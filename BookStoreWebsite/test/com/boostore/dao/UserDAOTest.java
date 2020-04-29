package com.boostore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.boostore.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() {

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);

	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("Frank@email.com");
		user1.setFullName("Frank Smith");
		user1.setPassword("Fpass");
		user1 = userDAO.create(user1);

		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);

	}

	@Test
	public void testUpdateUser() {
		Users user = new Users();
		user.setUserId(22);
		user.setEmail("Bob2@email.com");
		user.setFullName("Bob2");
		user.setPassword("Bpass");

		user = userDAO.update(user);
		String expected = "Apass";
		String actual = user.getPassword();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
		}

		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 100;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId =2;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 2;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUser = userDAO.listAll();
		
		for(Users user:listUser) {
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUser.size()>0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		
		assertEquals(3, totalUsers);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "alex@email.com";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.clear();
		entityManagerFactory.close();

	}
}
