package com.boostore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;

//	protected static EntityManagerFactory entityManagerFactory = Persistence
//			.createEntityManagerFactory("BookStoreWebsite");
//	protected static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}
}
