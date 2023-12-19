package com.company.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.model.Product;
import com.company.model.ProductReviews;

@Service
public class ProductServiceImpl implements ProductService {

	public ProductServiceImpl() {

		products.add(new Product(1l, "iphone", 1999));
		products.add(new Product(2l, "speaker", 599));
		products.add(new Product(3l, "book", 99));
	}

	List<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public Product getProduct(Long id) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getProductID().equals(id)) {
				return product;
			}
		}

		return null;
	}
	
	public void createProduct(Long productID, String productName, Integer price) {
		products.add(new Product(productID, productName, price));
	}
	
	public void updateProduct(Product product) {
		
		getProduct(product.getProductID()).setProductPrice(product.getProductPrice());
		getProduct(product.getProductID()).setProductName(product.getProductName());

	}
	

	public void deleteProduct(Long id) {
		System.out.println("Status.. "+products.remove(getProduct(id)));
		
	}

	@Override
	public List<ProductReviews> getProductReviews(Long id) {
		List<ProductReviews> reviewList = new ArrayList<>();
		ProductReviews review1 = new ProductReviews(1l, 1L, "Some review 1");
		ProductReviews review2 = new ProductReviews(2l, 1L, "Some review 2");
		
		reviewList.add(review1);
		reviewList.add(review2);
		
		return reviewList;
	}
}
