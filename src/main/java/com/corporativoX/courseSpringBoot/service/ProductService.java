package com.corporativoX.courseSpringBoot.service;

import java.util.List;

import com.corporativoX.courseSpringBoot.models.Product;

public interface ProductService {

//	Decimos que toda clase que lleve esta interface debe implementar esta funcion
	List<Product> getProducts();

}
