package com.corporativoX.courseSpringBoot.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.corporativoX.courseSpringBoot.models.Customer;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

//	? Simulacion de DB
	private List<Customer> customers = new ArrayList<>(Arrays.asList(
			new Customer(1, "Alexander", "AHP", "123456"),
			new Customer(2, "Tania", "TMC", "123456"),
			new Customer(3, "Alexander", "AHP1", "123456"),
			new Customer(4, "Alexander", "AHP2", "123456")
			));

	@GetMapping
//	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers(){
	
//		Antes de ResponseEntity<>
//		return customers;
		
//		Despues
//		Tipo de dato: ResponseEntity
//		Metodo: ok osea el codigo 200
//		Recurso: customer
		return ResponseEntity.ok(customers);
	}
	
//	Podemos tener la misma ruta base siempre y cuando tengamos un diferenciador
	@GetMapping("/{userName}")
//	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)

	/*	Cambiamos ResponseEntity<Customer> por ResponseEntity<?>
	 *  Para poder enviar nuestro mensaje personalizado
	 */
	public ResponseEntity<?> getCustomer(@PathVariable String userName) {
		for (Customer customer : customers) {
			if (customer.getUserName().equalsIgnoreCase(userName)) {
				
//				Antes de ResponseEntity
//				return customer;
				
//				Despues
				return ResponseEntity.ok(customer);
			}
		}
		
//		Deberiamos responder con manejo de excepcion 404, pero por ahora solo con null
//		return null;
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Cliente no encontrado con userName: " + userName);
	}
	
	@PostMapping
//	@RequestMapping(method = RequestMethod.POST)
//	RequestBody hace que sean transformados los datos que recibimos
	/*	Cambiamos ResponseEntity<Customer> por ResponseEntity<?>
	 *  Para poder enviar nuestro mensaje personalizado
	 */
	public ResponseEntity<?> postCliente(@RequestBody Customer customer) {
		customers.add(customer);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{username}")
						.buildAndExpand(customer.getUserName())
						.toUri();
/**
 * 		?Retornamos el status created y la URI de donde puede utilizar el nuveo customer
 */
		return ResponseEntity.created(location).body(customer);
						
		
//		return ResponseEntity
//				.status(HttpStatus.CREATED)
//				.body("Cliente creado exitosamente: " + customer.getUserName());		
	}
	
	@PutMapping
//	indicamos los parametros que llegaran, en este caso de tipo customer
	/*	Cambiamos ResponseEntity<Customer> por ResponseEntity<?>
	 *  Para poder enviar nuestro mensaje personalizado
	 */
	public ResponseEntity<?> putCliente(@RequestBody Customer customer) {
		for (Customer customerDB : customers) {
//			Comparamos los IDs del que recibimos y el que modificaremos
			if (customer.getID() == customerDB.getID()) {
				customerDB.setName(customer.getName());
				customerDB.setUserName(customer.getUserName());
				customerDB.setPassword(customer.getPassword());

				return ResponseEntity
						.ok("Cliente modificado satisfactoriamente: " + customerDB.getUserName());
//				return customerDB;
			}
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Cliente no encontrado: " + customer.getUserName() );
		
//		Deberiamos responder con manejo de excepcion 404, pero por ahora solo con null
//		return null;
	}
	
	@DeleteMapping("/{id}")
	/*	Cambiamos ResponseEntity<Customer> por ResponseEntity<?>
	 *  Para poder enviar nuestro mensaje personalizado
	 */
	public ResponseEntity<?> deleteCliente(@PathVariable int id) {
		for (Customer customerDB : customers) {
			if (customerDB.getID() == id) {
				customers.remove(customerDB);
				
				return ResponseEntity
						.status(HttpStatus.NO_CONTENT)
						.body("Cliente eliminado satisfactoriamente: " + id);
//				return customerDB;
			}
		}

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Cliente no encontrado: " + id );
	}
	
	@PatchMapping
	public ResponseEntity<?> patchCliente(@RequestBody Customer customer) {
		for (Customer customerDB : customers) {
			if (customerDB.getID() == customer.getID()) {
				if (customer.getName() != null) {
					customerDB.setName(customer.getName());
				}
				
				if (customer.getUserName() != null) {
					customerDB.setName(customer.getUserName());
				}
				
				if (customer.getPassword() != null) {
					customerDB.setName(customer.getPassword());
				}
				
				return ResponseEntity.noContent().build();
			}
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
