package com.corporativoX.courseSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetinRestController {

//	{name} : es el parametro web que recibiremos
	@GetMapping({"/saludo/{name}", "/hola/{name}"})
	public String greeting(@PathVariable String name) {
		return " Hola " + name;
	}
}
