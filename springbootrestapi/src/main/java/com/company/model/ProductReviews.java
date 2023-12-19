package com.company.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.ResourceSupport;

import com.company.controller.ProductController;

public class ProductReviews extends ResourceSupport {

	private ProductReviews() {
		super();
	}

	public ProductReviews(Long id, Long productID, String review) {
		super();
		this.ID = id;
		this.productID = productID;
		this.review = review;
		
		add(linkTo(methodOn(ProductController.class).getProduct(productID)).withRel("product"));
        add(linkTo(methodOn(ProductController.class).getReviewsForProduct(productID)).withSelfRel());
	}

	private Long ID;
	private Long productID;
	private String review;
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
