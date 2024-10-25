package com.corporativoX.courseSpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.corporativoX.courseSpringBoot.models.Product;

//En esta clase ponemos la Business Rule de Productos

/**
 * Ahora esta ya es un Bean por el @Service
 * 	Almacena esto en el contenedor, para cuando lo quiera inyectar
 * 	en otro lugar
 */
//Aqui se utilizo identificador para @Qualifier
//@Service("listResourceService")
@Service
@ConditionalOnProperty(name = "service.product", havingValue = "list")
public class ProductServiceImpl implements ProductService {

	List<Product> productsDB = new ArrayList<>(Arrays.asList(
				new Product(1, "Laptop", 15.0, 5),
				new Product(2, "Celular", 500.0, 5),
				new Product(3, "Tablet", 164.99, 5),
				new Product(4, "Mouse", 150.0, 5)
			));
	
/**
 * 	Como estamos implementando de una interfaz, tenemos que sobreescribir
 * esta funcion que ya fue establecida en la interfaz
 */
	@Override
	public List<Product> getProducts(){
		return productsDB;
	}
}
