package com.harshad.dto;

public class DiseaseDTO {
    private Long id;
	private String name;
	private String description;
	private String imageName;
    private int categoryId;





    // Constructor
    public DiseaseDTO(Long id, String name, String description, String imageName, int categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.categoryId = categoryId;
    }
  
    // Default Constructor

    public DiseaseDTO() {
    }

    
    // Generate Getter And Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    

   






    
}
