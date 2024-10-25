package com.corporativoX.courseSpringBoot.models;

public class Product {

/**
 * 	Si trabajamos con un framework es bueno crear los datos con
 * 	datos referenciales no primitivos, nos permite manejar los
 * valores nulos
 */
	private Integer id;
	private String nombre;
	private Double precio;
	private Integer stock;
	
//	Constructor vacio para JACKSON
	public Product() {
		
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param stock
	 */
	public Product(Integer id, String nombre, Double precio, Integer stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
