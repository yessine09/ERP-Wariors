package tn.projet.spring.entity;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.projet.spring.entity.Product;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Stock  implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock; // Clé primaire
	@NonNull
	private int qteStock;
	@NonNull
	private int qteMin;
	private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	@JsonIgnore
	private Set <Product> product;
	


}
