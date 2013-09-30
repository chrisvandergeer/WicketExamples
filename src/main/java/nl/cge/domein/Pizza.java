package nl.cge.domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Pizza implements Serializable {
	
	private String naam;
	private Double prijs;
	
	public static List<Pizza> findAll() {
		return new ArrayList<Pizza>(
			Arrays.asList(new Pizza[] { 
				create("Quatro statiogni", 9d), create("Quatro Fromage", 10d), create("Tonno", 9.5d)
			})
		);
	}
	
	public static Pizza create(String naam, Double prijs) {
		Pizza pizza = new Pizza();
		pizza.setNaam(naam);
		pizza.setPrijs(prijs);
		return pizza;
	}
}
