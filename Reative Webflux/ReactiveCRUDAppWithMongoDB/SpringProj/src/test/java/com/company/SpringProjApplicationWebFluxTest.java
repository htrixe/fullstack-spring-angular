package com.company;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.company.controller.ProductController;
import com.company.model.Product;
import com.company.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest(controllers = ProductController.class)
class SpringProjApplicationWebFluxTest {

	@MockBean
	ProductRepository repository;

	@Autowired
	private WebTestClient webClient;

	@Test
	void testFlux() {
		Flux<String> publisher = Flux.just("Apple", "Banana", "Pineapple");

		StepVerifier.create(publisher).expectNextCount(3).verifyComplete();

	}

	@Test
	void testCreateProduct() {
		Product product = new Product();
		product.setId("1");
		product.setProductName("Test");

		Mockito.when(repository.save(product)).thenReturn(Mono.just(product));

		webClient.post().uri("/products").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(product))
				.exchange().expectStatus().is2xxSuccessful();

	}

	@Test
	void testGetProduct() {
		Product product = new Product();
		product.setId("1");
		product.setProductName("Test");

		Mockito.when(repository.findById("1")).thenReturn(Mono.just(product));

		webClient.get().uri("/products/{id}", 1).exchange().expectStatus().isOk().expectBody().jsonPath("$.id")
				.isEqualTo(1).jsonPath("$.productName").isEqualTo("Test");

	}

}
