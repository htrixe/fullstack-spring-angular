package com.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Product;
import com.company.model.ProductReviews;
import com.company.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("")
	Resources<Product> getProducts() {
		Link selfRelLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(ProductController.class).getProducts()).withSelfRel();

		List<Product> productList = productService.getProducts();

		Resources<Product> resources = new Resources<>(productList);
		resources.add(selfRelLink);
		return resources;
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}

	@PostMapping(value = "")
	public Map<String, Object> createProduct(@RequestParam(value = "id") Long id,
			@RequestParam(value = "name") String name, @RequestParam(value = "price") Integer price) {

		productService.createProduct(id, name, price);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "Product added!");
		return map;
	}

	@PutMapping(value = "")
	public Product updateProductUsingJson(@RequestBody Product product) {
		productService.updateProduct(product);
		return product;
	}

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "Product deleted!");
		return map;
	}

	@GetMapping(value = "/{productId}/reviews")
	public Resources<ProductReviews> getReviewsForProduct(@PathVariable final long productId) {

		List<ProductReviews> reviews = productService.getProductReviews(productId);
		return new Resources<ProductReviews>(reviews);

	}

}
