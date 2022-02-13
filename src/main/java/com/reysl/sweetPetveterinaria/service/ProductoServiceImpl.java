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

	@Override
	public Producto getProductoById(Long id) throws Exception {
		return productoRepository.findById(id).orElseThrow(() -> new Exception("El producto a editar no existe"));
	}

	@Override
	public Producto updateProducto(Producto fromProducto) throws Exception {
		Producto toProducto = getProductoById(fromProducto.getId());
		mapProducto(fromProducto, toProducto);
		
		return productoRepository.save(toProducto);
	}
	
	protected void mapProducto(Producto from, Producto to) {
		to.setDescripcion(from.getDescripcion());
		to.setCategoria(from.getCategoria());
		to.setPrecio(from.getPrecio());
		to.setUnidades(from.getUnidades());
	}

	@Override
	public void deleteProducto(Long id) throws Exception {
		Producto producto = productoRepository.findById(id).orElseThrow(() -> new Exception("El usuario no existe!!"));
		
		productoRepository.delete(producto);		
	}

	@Override
	public Producto venderProducto(Long id) throws Exception {
		Producto producto = productoRepository.findById(id).orElseThrow(() -> new Exception("El producto no existe!!"));
		
		if(producto.getUnidades() > 0) {
			producto.setUnidades(producto.getUnidades()-1);
		}
		return productoRepository.save(producto);
	}
	
}
