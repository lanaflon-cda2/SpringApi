package fr.dawan.entrepriseapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.entrepriseapi.entities.Employe;
import fr.dawan.entrepriseapi.entities.Login;
import fr.dawan.entrepriseapi.services.EmployeService;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CrudController {
	
	@Autowired
	private EmployeService employeService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Employe create(@RequestBody Employe user) {
		employeService.save(user);
		return user;
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteByID(@PathVariable("id") long id) {
		employeService.deleteById(id);
	}

	@GetMapping(value = "/all", produces = "application/json")
	public List<Employe> findAllEmployee() {
		return employeService.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Optional<Employe> findById(@PathVariable("id") long id) {
		return employeService.findById(id);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public Employe edit(@RequestBody Employe user) {
		employeService.save(user);
		return user;
	}
	/**
	 * AUTHENTIFICATION
	 * */
	@RequestMapping("/auth")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Employe log(@RequestBody Login credentials) {
		return employeService.findByLogin(credentials);
	}
}
