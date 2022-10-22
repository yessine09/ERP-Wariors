package tn.projet.spring.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.projet.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

}


