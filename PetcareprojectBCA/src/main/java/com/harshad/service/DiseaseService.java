package com.harshad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.Disease;
import com.harshad.repository.DiseaseRepository;

@Service
public class DiseaseService {
    @Autowired 
    DiseaseRepository diseaseRepository;
	public List<Disease> getAllDisease(){return diseaseRepository.findAll();}

	public void addDisease(Disease product) {
		diseaseRepository.save(product);
	}

	public void removeDiseaseById(long id) {
		diseaseRepository.deleteById(id);
	}
	public Optional<Disease> getDiseaseById(long id){
		return diseaseRepository.findById(id);
	}
	
	public List<Disease> getAllDiseaseByCategoryId(int id){
		return diseaseRepository.findAllByCategory_Id(id);
	}
}
