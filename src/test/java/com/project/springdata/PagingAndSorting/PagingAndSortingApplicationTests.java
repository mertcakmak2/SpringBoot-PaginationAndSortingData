package com.project.springdata.PagingAndSorting;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.project.springdata.PagingAndSorting.Entities.Product;
import com.project.springdata.PagingAndSorting.Repos.IProductRepository;

@SpringBootTest
class PagingAndSortingApplicationTests {
	
	@Autowired
	IProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testMultiSort() {
//		List<Product> products = (List<Product>) repository.findAll(Sort.by("name").and(Sort.by("price")));
		List<Product> products =  (List<Product>) repository.findAll(Sort.by("name","price"));
		products.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));
	}
	
	@Test
	public void testMultiSortByList() {
		String [] fields = {"name","price"};
		List<Product> products =  (List<Product>) repository.findAll(Sort.by(fields));
		products.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));
	}

}
