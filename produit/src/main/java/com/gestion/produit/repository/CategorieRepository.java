package com.gestion.produit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.produit.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	List<Categorie> findByNomContains(String nom);
	
}
