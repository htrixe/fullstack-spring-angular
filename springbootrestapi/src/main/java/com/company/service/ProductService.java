package com.company.service;

import java.util.List;

import com.company.model.Product;
import com.company.model.ProductReviews;

public interface ProductService {
	List<Product> getProducts();
	Product getProduct(Long id);
	void createProduct(Long productID, String productName, Integer price);
	void updateProduct(Product product);
	void deleteProduct(Long id);
	List<ProductReviews> getProductReviews(Long id);
}
