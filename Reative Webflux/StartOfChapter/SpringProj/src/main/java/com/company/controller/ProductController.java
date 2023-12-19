package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("")
	void getProducts() {
		
		List<String> products = new ArrayList<String>();
		Flux.just("Apple","Banana","Orange","iPhone").subscribe(new Subscriber() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Object t) {
				products.add((String) t);				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
		});
		
		logger.info(products.toString());
	}

}
