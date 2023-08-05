package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.service.to.VehiculoTO;

public interface IVehiculoService {

	public Vehiculo recuperarporPlaca(String placa);

	public List<VehiculoTO> recuperarTodos();

}
