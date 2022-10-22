package tn.projet.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.projet.spring.entity.Stock;



@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
