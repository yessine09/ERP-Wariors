package tn.projet.spring.service;

import java.util.List;

import tn.projet.spring.entity.Stock;

public interface IStock {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	void deleteStock(Long id);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
}
