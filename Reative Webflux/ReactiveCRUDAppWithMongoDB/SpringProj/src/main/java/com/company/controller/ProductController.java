package com.company.controller;

import java.time.Duration;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Product;
import com.company.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	Flux<Product> getProducts() {

		return productRepository.findAll();
	}

	@PostMapping("/products")
	Mono<Product> postProducts(@Valid @RequestBody Product product) {

		return productRepository.save(product);
	}

	@GetMapping("/products/{id}")
	public Mono<ResponseEntity<Product>> getProductById(@PathVariable(value = "id") String productId) {
		return productRepository.findById(productId).map(savedProduct -> ResponseEntity.ok(savedProduct))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping("/products/{id}")
	public Mono<ResponseEntity<Product>> updateProduct(@PathVariable(value = "id") String productId,
			@Valid @RequestBody Product product) {
		return productRepository.findById(productId).flatMap(existingProduct -> {
			existingProduct.setProductName(product.getProductName());
			return productRepository.save(existingProduct);
		}).map(updatedProduct -> new ResponseEntity<>(updatedProduct, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/products/{id}")
	public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable(value = "id") String productId) {

		return productRepository.findById(productId)
				.flatMap(existingProduct -> productRepository.delete(existingProduct)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// Products are Sent to the client as Server Sent Events
	@GetMapping(value = "/stream/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> streamAllProducts() {
		return productRepository.findAll().delayElements(Duration.ofSeconds(1));
	}

}
