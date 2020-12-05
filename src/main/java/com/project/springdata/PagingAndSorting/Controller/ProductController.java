package com.project.springdata.PagingAndSorting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springdata.PagingAndSorting.Entities.Product;
import com.project.springdata.PagingAndSorting.Repos.IProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	public IProductRepository repository;
	
	@GetMapping("/pagination/{page}/{size}")
	public List<Product> getPageable(@PathVariable int page, @PathVariable int size ) {
//		Pageable firstPageWithTwoElements = PageRequest.of(page, size) ;		
		Pageable firstPageWithTwoElements = PageRequest.of(page, size, Sort.by("name"));
		return repository.findAll(firstPageWithTwoElements).getContent(); 
	}
}
