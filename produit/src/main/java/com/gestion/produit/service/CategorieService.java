package com.gestion.produit.service;

import java.util.List;

import com.gestion.produit.entities.Categorie;

public interface CategorieService {
	public void persistCategorie(Categorie c );
	public void deleteCategorie(int id);
	public List<Categorie> getAllCategorie();
	public Categorie findCategorieById(int id);
	public List<Categorie> findCategorieByNom(String nom);
	public void updateCategorie(Categorie c);
}
