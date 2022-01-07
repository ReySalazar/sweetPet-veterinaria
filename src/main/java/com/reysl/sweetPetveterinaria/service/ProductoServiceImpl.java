package com.reysl.sweetPetveterinaria.service;

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
	
}
