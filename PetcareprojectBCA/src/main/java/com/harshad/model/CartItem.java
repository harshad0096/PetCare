package com.harshad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   // @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id")
    //private Product product;

    @Column(name = "quantity")
    private int quantity;

   // @Column(name = "user_id")
    //private String userId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//public Product getProduct() {
	//	return product;
	//}

	//public void setProduct(Product product) {
	//	this.product = product;
	//}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//
	//public String getUserId() {
	//	return userId;
	//}

	//public void setUserId(String userId) {
	//	this.userId = userId;
	//}

	public CartItem() {
        this.id = id;
      //  this.product = product;
      //  this.quantity = quantity;
      //  this.userId = userId;
    }
    
    

    // getters and setters omitted for brevity
}
 