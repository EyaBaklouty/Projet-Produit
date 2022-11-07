package com.gestion.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.produit.entities.Categorie;
import com.gestion.produit.service.CategorieService;
import com.gestion.produit.service.ProduitService;

@Controller
@RequestMapping("/categorie/")
public class CategorieController {

	@Autowired
	ProduitService produitService;
	@Autowired
	CategorieService categorieService;
	
	@GetMapping("all")
	public String index(Model model) {
		model.addAttribute("produits",produitService.getAllProduits());
		model.addAttribute("categories",categorieService.getAllCategorie());
		return "show";
		}
	@GetMapping("add")
	public String showFormAdd() {
		return "add";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		categorieService.deleteCategorie(id);
		return "redirect:/categorie/all";
	}
	@PostMapping("add")
	public String add(Categorie c) {
		categorieService.persistCategorie(c);
		return "redirect:/categorie/all";
	}
	@GetMapping("update/{id}")
	public String edit(Model model,@PathVariable int id) {
		model.addAttribute("categorie",categorieService.findCategorieById(id));
		return "update";
	}
	@PostMapping("update")
	public String update(Categorie c) {
		categorieService.updateCategorie(c);
		return "redirect:/categorie/all";
	}
	@PostMapping("find")
	public String findbynom(@RequestParam String motcle, Model model) {
		model.addAttribute("categories", categorieService.findCategorieByNom(motcle));
		model.addAttribute("produits", produitService.getAllProduits());
		return "show";
	}
	
}
