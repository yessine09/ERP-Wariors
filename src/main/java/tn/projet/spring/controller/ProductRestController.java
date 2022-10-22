package tn.projet.spring.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.projet.spring.entity.Product;

import tn.projet.spring.service.IProduct;


@RestController
public class ProductRestController {

	@Autowired
	IProduct produitService;
	
    // http://localhost:8088/SpringMVC/servlet/retrieve-all-produits

	@GetMapping("/retrieve-all-produits")

	@ResponseBody
	public List<Product> getProduits() {
		List<Product> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}

	// recupérer selon l'id
	
	// http://localhost:8087/SpringMVC/servlet/retrieve-produit/id
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Product retrieveProduct(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	// http://localhost:8087/SpringMVC/servlet/add-product
	    
	@PostMapping("/add-product") 
    @ResponseBody
		
		public Product addProduct(@RequestBody Product p) {	 
		return produitService.addProduit(p);
		}

	// http://localhost:8087/SpringMVC/servlet/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {

		produitService.deleteProduit(produitId);
		System.out.println("Deleted successfuly");
	}

	// http://localhost:8087/SpringMVC/servlet/modify-produit
	@PutMapping("/modify-produit")
	@ResponseBody
	public Product modifyProduit(@RequestBody Product p) {
		return produitService.updateProduit(p);
	}
	
	@PutMapping("Affecter/{produit-id}/{stock-id}")
	@ResponseBody
public void affecterProduitToStock(@PathVariable ("produit-id") Long idProduit,@PathVariable ("stock-id") Long idStock) {
	produitService.affecterProduitToStock(idProduit, idStock);
	System.out.println("success");
}
	
//	 @GetMapping(value = "/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}")
//		@ResponseBody
//        public float getRevenuBrutProduit(@PathVariable("idProduit") Long idProduit,
//                        @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//                        @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
//
//                return produitService.getRevenuBrutProduit(idProduit, startDate, endDate);
//        }

}
