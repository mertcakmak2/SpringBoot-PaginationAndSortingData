package com.project.springdata.PagingAndSorting.Repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.springdata.PagingAndSorting.Entities.Product;

public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
	List<Product> findByName(String string);
	List<Product> findByNameAndDesc(String name, String desc);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByDescContains(String price);
	List<Product> findByPriceBetween(Double price1, Double price2);
	List<Product> findByDescLike(String desc);
	List<Product> findByIdIn(int ids []);
}
