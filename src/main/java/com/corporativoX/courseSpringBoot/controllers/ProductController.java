package com.corporativoX.courseSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corporativoX.courseSpringBoot.models.Product;
import com.corporativoX.courseSpringBoot.service.ProductService;
import com.corporativoX.courseSpringBoot.service.ProductServiceImpl;

@RestController
@RequestMapping("/productos")
public class ProductController {

//	Hacemos la instancia a ProductServiceImpl
//	ProductServiceImpl productService = new ProductServiceImpl();

/**
 * 	Como ya tenemos una interfaz abstracta entonces ahora debemos
 * 	de hacer la instancia con Polimorfismo dinamico
 * 		Esto nos permite cambiar el comportamiento a un objeto
 */
//	ProductService productService = new ProductServiceImpl();
	
	/**
	 * Hacemos la inyeccion de dependencia con Autowired, pues
	 * 	Autowired detecta automaticamente la dependencia del Bean
	 * 	en este caso @Service de ProductServiceImpl
	 */
	@Autowired
//	@Qualifier("listResourceService")
//	Esto es composicion, hace referencia a un objeto desde los atributos de una clase
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getProducts() {
		List<Product> products = productService.getProducts();
		
		return ResponseEntity.ok(products);
		
	}
	
}
