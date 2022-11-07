package com.gestion.produit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.produit.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	List<Produit> findByNomContains(String nom);
	
//	@Query("select p from Produit p where p.nom like %:x%")
//	List<Produit> rechercherparnom(@Param("x") String nom);
}
