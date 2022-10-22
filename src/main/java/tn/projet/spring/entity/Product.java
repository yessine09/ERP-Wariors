package tn.projet.spring.entity;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;
	
	






@ManyToOne
Stock stock;




}
