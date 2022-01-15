package com.reysl.sweetPetveterinaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reysl.sweetPetveterinaria.entity.Producto;
import com.reysl.sweetPetveterinaria.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public Iterable<Producto> getAllProductos(){
		
		return productoRepository.findAll();
		
	}
	
	private boolean checkNombreAvailable(Producto producto) throws Exception {
		
		Optional<Producto> productoEncontrado = productoRepository.findByDescripcion(producto.getDescripcion());
		if (productoEncontrado.isPresent()) {
			throw new Exception("El producto ingresado ya existe");
		}
		return true;
		
	}

	@Override
	public Producto crearProducto(Producto producto) throws Exception {
		if (checkNombreAvailable(producto)) {
			producto = productoRepository.save(producto);
		}
		
		return producto;
		
	}
	
}
