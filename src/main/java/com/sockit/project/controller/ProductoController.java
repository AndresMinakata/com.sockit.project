package com.sockit.project.controller;
import com.sockit.project.service.ProductoService;
import com.sockit.project.model.Producto;
import java.util.List;

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
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api/products/")
public class ProductoController {
private final ProductoService productoService;

@Autowired
public ProductoController(ProductoService productoService) {
	super();
	this.productoService = productoService;
}//constructor

//CRUD
@GetMapping
public List<Producto> getAllProductos(){
	return productoService.getProductos();
}//getAllProductos

@GetMapping(path= "{prodId}")
public Producto getProducto(@PathVariable("prodId") Long Id){
	return productoService.getProducto(Id);
}//getProductosbyId

@DeleteMapping(path= "{prodId}")
public Producto deleteProducto(@PathVariable("prodId") Long Id){
	return productoService.deleteProducto(Id);
}//DeleteProductosbyId

@PostMapping
public Producto addProducto(@RequestBody Producto producto){
	return productoService.addProducto(producto);
}//PostProductos

@PutMapping(path= "{prodId}")
public Producto UpdateProducto(@PathVariable("prodId") Long id, 
		@RequestParam (required = false)String nombre,
		@RequestParam (required = false)String descripcion,
		@RequestParam (required = false)String URL_imagen,
		@RequestParam (required = false)Double precio) {
	return productoService.updateProducto(id, nombre, descripcion, URL_imagen, precio);
}//UpdateProductos

}//class ProductoController
