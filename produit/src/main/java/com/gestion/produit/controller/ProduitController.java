package com.gestion.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.produit.entities.Produit;
import com.gestion.produit.service.CategorieService;
import com.gestion.produit.service.ProduitService;


@Controller
@RequestMapping("/produit/")
public class ProduitController {

	@Autowired
	ProduitService produitService;
	@Autowired
	CategorieService categorieService;
	
	@GetMapping("all")
	public String index(Model model) {
		model.addAttribute("produits",produitService.getAllProduits());
		model.addAttribute("categories",categorieService.getAllCategorie());
		return "index";
		}
	@GetMapping("add")
	public String showFormAdd(Model model) {
		model.addAttribute("categories",categorieService.getAllCategorie());
		return "ajout";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		produitService.deleteProduit(id);
		return "redirect:/produit/all";
	}
	@PostMapping("add")
	public String add(Produit p) {
		produitService.persistProduit(p);
		return "redirect:/produit/all";
	}
	@GetMapping("update/{id}")
	public String edit(Model model,@PathVariable int id) {
		model.addAttribute("categories",categorieService.getAllCategorie());
		model.addAttribute("produit",produitService.findProduitById(id));
		return "modif";
	}
	@PostMapping("update")
	public String update(Produit p) {
		produitService.persistProduit(p);
		return "redirect:/produit/all";
	}
	@PostMapping("find")
	public String findbynom(@RequestParam String motcle, Model model) {
		model.addAttribute("produits", produitService.findProduitsByNom(motcle));
		model.addAttribute("categories", categorieService.getAllCategorie());
		return "index";
	}
	
}
