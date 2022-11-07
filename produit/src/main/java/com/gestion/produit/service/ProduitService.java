package com.gestion.produit.service;

import java.util.List;

import com.gestion.produit.entities.Produit;

public interface ProduitService {
	public Produit persistProduit(Produit p );
	public void deleteProduit(int id);
	public List<Produit> getAllProduits();
	public Produit findProduitById(int id);
	public List<Produit> findProduitsByNom(String nom);
	public void updateProduit(Produit p);
}
