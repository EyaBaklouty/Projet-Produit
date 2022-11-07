package com.gestion.produit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.produit.entities.Produit;
import com.gestion.produit.service.ProduitService;

@RestController
@RequestMapping("/api/produits")
public class RestProduitController {

	@Autowired
	ProduitService ProduitService;
	
	@GetMapping("")
	public List<Produit> all(){
	return ProduitService.getAllProduits();
	}

	@GetMapping("/{id}")
	public Produit getProduit (@PathVariable int id){
	return ProduitService.findProduitById(id);
	}

	@PostMapping("/add")
	public Produit add (@RequestBody Produit p){
	return ProduitService.persistProduit(p);
	}
	
	@PutMapping("/update")
	public Produit update(@RequestBody Produit p) {
		return ProduitService.persistProduit(p);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) { 
		ProduitService.deleteProduit(id);
		return "Suppression réussite";
	}
	
	/*@PostMapping("/findbycat")
	public List<Produit> add(@RequestParam int idc){
		return ProduitService.findProduitByCat(idc);
	}*/
	
}
