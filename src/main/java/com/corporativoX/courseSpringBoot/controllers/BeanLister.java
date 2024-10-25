package com.corporativoX.courseSpringBoot.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beanlist")
public class BeanLister {

	@Autowired
	private ApplicationContext appContext;
	
	@GetMapping
	public String listAllBeanWithTypes() {
		String[] beanNames = appContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			Object bean = appContext.getBean(beanName);
			System.out.print("Bean name: " + beanName + ", BeanType: " + bean.getClass().getName());
		}
		return "working";
	}   
}
