package com.corporativoX.courseSpringBoot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.corporativoX.courseSpringBoot.models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  Ponemos este Bean @Service como predeterminado, @Primary tiene menor 
 *  	prioridad que @Qualifier, al igual que @ConditionalProperty < @Qualifier
 */
//@Primary
// Indicamos que es Bean de servicio, se almacena en el contenedor de Spring
//@Service("jsonResourceService")
@Service
@ConditionalOnProperty(name = "service.product", havingValue = "json")
public class ProductsServiceJSONImpl implements ProductService {

	@Override
	public List<Product> getProducts() {
		
		try {
			List<Product> productsDB = new ObjectMapper()
							.readValue(this.getClass().getResourceAsStream("/products.json"),
									new TypeReference<List<Product>>() {});
//			Retornamos los datos deserializados de poducts.JSON
			return productsDB;
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	
}
