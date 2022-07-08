package com.sockit.project.service;

import java.util.List;
import java.util.Optional;
import com.sockit.project.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
private final ProductoRepository productoRepository;
@Autowired
public ProductoService(ProductoRepository productoRepository) {
	super();
	this.productoRepository = productoRepository;
}//constructor

public List<Producto> getProductos() {
	return productoRepository.findAll();
}//getAllProductos

public Producto getProducto(Long Id) {
	return productoRepository.findById(Id).orElseThrow(
			()-> new IllegalArgumentException("El producto con el id"+ Id +"No existe")
			);
}//getProductoById

public Producto deleteProducto(Long Id) {
	Producto tmpProd = null;
	if (productoRepository.existsById(Id)){
		tmpProd = productoRepository.findById(Id).get();
	productoRepository.deleteById(Id);
	}//if
	return tmpProd;
}//deleteProducto
public Producto addProducto(Producto producto) {
    Producto tmpProd = null;
	Optional<Producto> prodByName = productoRepository.findByNombre(producto.getNombre());
	
	if (prodByName.isPresent()) {
		throw new IllegalArgumentException("El producto con el nombre ["+producto.getNombre()+"] ya existe");
	} else {
		productoRepository.save(producto);	
		tmpProd = producto;
	}//if & else
	return tmpProd;
}//addProducto

public Producto updateProducto(Long Id, String nombre, String descripcion, String uRL_imagen, Double precio) {
	Producto tmpProd = null;
	if (productoRepository.existsById(Id)){
		tmpProd = productoRepository.findById(Id).get();
		if(nombre!=null) tmpProd.setNombre(nombre);
		if(descripcion!=null) tmpProd.setDescripcion(descripcion);
		if(uRL_imagen!=null) tmpProd.setURL_imagen(uRL_imagen);
		if (precio!=null) tmpProd.setPrecio(precio.doubleValue());
		productoRepository.save(tmpProd);
	} else {
		System.out.println("El producto con el id"+ Id +"No existe");
	}//if
	return tmpProd;
}//UpdateProducto


}//class ProductoService
