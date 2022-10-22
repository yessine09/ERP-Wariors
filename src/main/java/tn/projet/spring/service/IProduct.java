package tn.projet.spring.service;

import java.util.Date;
import java.util.List;

import tn.projet.spring.entity.Product;

public interface IProduct {
	List<Product> retrieveAllProduits();

	Product addProduit(Product p);

	void deleteProduit(Long id);

	Product updateProduit(Product u);

	Product retrieveProduit(Long id);
	
	String affecterProduitToStock(Long idProduit, Long idStock);
	
    //float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
	


}
