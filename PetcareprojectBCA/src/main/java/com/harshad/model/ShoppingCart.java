package com.harshad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Column;

import com.harshad.dto.CartItemDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart{
    private Long id;
	@Column(nullable = false)
    private User user;
	@Column(nullable = false)
    private double totalPrice;
	@Column(nullable = false)
    private int totalItems;
	@Column(nullable = false)
    private Set<CartItemDto> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCustomer() {
		return user;
	}

	public void setCustomer(User user) {
		this.user = user;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public Set<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

    
}
