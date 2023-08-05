package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVehiculoRepository;
import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public Vehiculo recuperarporPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscarporPlaca(placa);
	}

	@Override
	public List<VehiculoTO> recuperarTodos() {
		// TODO Auto-generated method stub
				List<Vehiculo> lista = this.iVehiculoRepository.buscarTodos();
				List<VehiculoTO> listaTO = lista.stream().map(vehiculo -> this.convertir(vehiculo)).collect(Collectors.toList());
				return listaTO;
	}		
				private VehiculoTO convertir(Vehiculo vehiculo) {
					VehiculoTO veh = new VehiculoTO();
					veh.setId(vehiculo.getId());
					veh.setAnio(vehiculo.getAnio());
					veh.setCilindraje(vehiculo.getCilindraje());
					veh.setModelo(vehiculo.getModelo());
					veh.setPlaca(vehiculo.getPlaca());

					return veh;
				
	}
}

