package com.reysl.sweetPetveterinaria.service;

import com.reysl.sweetPetveterinaria.entity.Producto;

public interface ProductoService {
	
	public Iterable<Producto> getAllProductos();

	public Producto crearProducto(Producto producto) throws Exception;

	public Producto getProductoById(Long id) throws Exception;

	public Producto updateProducto(Producto producto) throws Exception;
	
	public void deleteProducto(Long id) throws Exception;

	public Producto venderProducto(Long id) throws Exception;
	
}
