package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.service.to.VehiculoTO;

public interface IVehiculoRepository {
	
	public Vehiculo buscarporPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();

}
