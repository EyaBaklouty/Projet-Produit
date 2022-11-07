package com.gestion.produit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.produit.entities.Produit;
import com.gestion.produit.repository.ProduitRepository;
@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	ProduitRepository produitRepository;
	
	@Override
	public Produit persistProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(int id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public Produit findProduitById(int id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> findProduitsByNom(String nom) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomContains(nom);
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.save(p);
	}

}