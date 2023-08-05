package com.uce.edu.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.service.IVehiculoService;
import com.uce.edu.demo.service.to.VehiculoTO;



@RestController
@RequestMapping("/vehiculos")
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService IVehiculoService;
	
	
	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vehiculo consultarPlaca(@PathVariable String placa) {
		return this.IVehiculoService.recuperarporPlaca(placa);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> consultarTodosHATEOAS() {
		List<VehiculoTO> lista = this.IVehiculoService.recuperarTodos();
		for(VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerRestful.class).consultarPlaca(v.getPlaca())).withRel("placas");
			v.add(myLink);

		}


		return new ResponseEntity<>(lista, null, 200);

	}


		
	}
	
	
