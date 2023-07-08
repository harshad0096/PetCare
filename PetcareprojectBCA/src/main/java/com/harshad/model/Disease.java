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
@Table(name = "blog")
public class Disease {
    
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable = false)
private String name;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "category_id",referencedColumnName = "category_id" )
private AnimalCategory category;

@Column(length = 1000,nullable = false)
private String description;
@Column(nullable = false)
private String imageName;
// public Product(Long id, String name, Category category, double price, String description, String imageName) {
// 	super();
// 	this.id = id;
// 	this.name = name;
// 	this.category = category;
// 	this.price = price;
// 	this.description = description;
// 	this.imageName = imageName;
// }
// Constructor

public Long getId() {
	return id;
}
public Disease(Long id, String name, AnimalCategory category, double price, String description, String imageName) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.description = description;
    this.imageName = imageName;
}


// Generate GEtter And Setter
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public AnimalCategory getCategory() {
    return category;
}
public void setCategory(AnimalCategory category) {
	this.category = category;
}

public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public String getImageName() {
    return imageName;
}
public void setImageName(String imageName) {
    this.imageName = imageName;
}

// Default Constructor
public Disease() {
}



}
