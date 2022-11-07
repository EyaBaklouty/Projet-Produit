package com.gestion.produit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.produit.entities.Categorie;
import com.gestion.produit.repository.CategorieRepository;
import com.gestion.produit.repository.ProduitRepository;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public void persistCategorie(Categorie c) {
		// TODO Auto-generated method stub
		categorieRepository.save(c);
	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie findCategorieById(int id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id).get();
	}

	@Override
	public List<Categorie> findCategorieByNom(String nom) {
		// TODO Auto-generated method stub
		return categorieRepository.findByNomContains(nom);
	}

	@Override
	public void updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		categorieRepository.save(c);
	}
	

}
