package com.harshad.service;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.CartItem;
import com.harshad.model.Product;
import com.harshad.model.User;
import com.harshad.repository.CartItemRepository;
import com.harshad.repository.ProductRepository;
import com.harshad.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void addToCart(Long productId, String userId) {
		Product product = productRepository.findById(productId).orElse(null);
		User user = userRepository.getById(userId);
		
		if (product != null && user != null) {
			CartItem cartItem = new CartItem();
		//	cartItem.setProduct(product);
			cartItem.setQuantity(1);
		//	cartItem.setUserId(userId);
			
			cartItemRepository.save(cartItem);
		}
	}
}*/
