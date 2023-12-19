package com.company.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.company.controller.ProductController;

public class Product extends ResourceSupport {

	private Product() {
		super();
	}

	public Product(Long productID, String productName, Integer productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		
        add(new Link("/products/"+ productID).withSelfRel());
        add(linkTo(methodOn(ProductController.class).deleteProduct(productID)).withRel("delete"));
        add(linkTo(methodOn(ProductController.class).updateProductUsingJson(new Product())).withRel("update"));
        add(linkTo(methodOn(ProductController.class).getReviewsForProduct(productID)).withRel("Reviews"));
	}

	private Long productID;
	
	@NotBlank(message = "Name is a mandatory field")
	private String productName;
	private Integer productPrice;

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

}
