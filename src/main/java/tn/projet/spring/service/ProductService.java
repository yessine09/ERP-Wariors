package tn.projet.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.projet.spring.entity.Product;
import tn.projet.spring.entity.Stock;

import tn.projet.spring.repository.ProductRepository;
import tn.projet.spring.repository.StockRepository;
import tn.projet.spring.service.IProduct;



@Service
public class ProductService implements IProduct {
	@Autowired
	private ProductRepository produitRepository;
	@Autowired
	private StockRepository stockRepository;


	@Override
	public List<Product> retrieveAllProduits() {
		// TODO Auto-generated method stub
		//List<Produit> produits = (List<Produit>) produitRepository.findAll();
		List<Product> produits =  produitRepository.findAll();
		return produits;
	}

	@Override
	public Product addProduit(Product p) {
		// TODO Auto-generated method stub
		produitRepository.save(p);
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);

	}

	@Override
	public Product updateProduit(Product u) {
		// TODO Auto-generated method stub
		return produitRepository.save(u);
	}

	@Override
	public Product retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Product produit = produitRepository.findById(id).orElse(null);
		return produit;
	}
	
	@Override
	public String affecterProduitToStock(Long idProduit, Long idStock) {

		Stock stock= stockRepository.findById(idStock).get();
		Product produit=produitRepository.findById(idProduit).get();

		produit.setStock(stock);
		produitRepository.save(produit);
		return "success";



	}


	
}