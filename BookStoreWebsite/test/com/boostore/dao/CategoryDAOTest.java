package com.boostore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryDAOTest extends BaseDAOTest {

	private static CategoryDAO categoryDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		categoryDao = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateCategory() {
		Category newCat = new Category("Health");
		Category category = categoryDao.create(newCat);
		
		assertTrue(category != null && category.getCategoryId()>0);
		
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category("Java Core");
		cat.setCategoryId(11);
		
		Category category = categoryDao.update(cat);
		
		assertEquals(cat.getName(), category.getName());
	}

	@Test
	public void testGet() {
		Integer catId = 12;
		Category cat = categoryDao.get(catId);
		
		assertNotNull(cat);
	}

	@Test
	public void testDeleteCategory() {
		Integer catId = 13;
		categoryDao.delete(catId);
		
		Category cat = categoryDao.get(catId);
		assertNotNull(cat);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDao.listAll();
		
		listCategory.forEach(c-> System.out.println(c.getName() + ","));
		
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDao.count();
		
		assertEquals(4, totalCategories);
	}
	
	@Test
	public void testFindByName() {
		
		String name = "Java Core";
		Category category = categoryDao.findByName(name);
		
		assertNotNull(category);
	}
	@Test
	public void testFindByNameNotFound() {
		String name = "Java Core1";
		Category category = categoryDao.findByName(name);
		
		assertNull(category);
	}

}
