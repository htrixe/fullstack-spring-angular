package com.company.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {

	public Product() {
		super();
	}

    public Product(String id, @NotBlank @Size(max = 140) String productName) {
		super();
		this.id = id;
		this.productName = productName;
	}

	@Id
    private String id;

    @NotBlank
    @Size(max = 140)
    private String productName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
