package tn.projet.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.projet.spring.entity.Stock;
import tn.projet.spring.service.StockService;

@RestController
@RequestMapping("/stock")

public class StockRestController {
	@Autowired
	StockService stockService;

	// http://localhost:8087/SpringMVC/servlet/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getFactures() {
		List<Stock> listFactures = stockService.retrieveAllStocks();
		return listFactures;
	}

	// recupérer selon l'id
	
	// http://localhost:8087/SpringMVC/servlet/stock/retrieve-stocks/id
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveFacture(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	// http://localhost:8087/SpringMVC/servlet/stock/add-stock
	@PostMapping("/add-stock/{idStock}")

	@ResponseBody

	public Stock addStock(@RequestBody Stock f, @PathVariable("idStock") Long idStock) {
		return stockService.addStock(f);
	}

	// http://localhost:8087/SpringMVC/servlet/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {

		stockService.deleteStock(stockId);
		System.out.println("Deleted successfuly");
	}

	// http://localhost:8087/SpringMVC/servlet/stock/modify-stock
	@PutMapping("/modify-stock/{idStock}")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock, @PathVariable("idStock") Long idStock) {
		return stockService.updateStock(stock);
	}

}