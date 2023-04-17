package com.eoi.Facturacion.services;

import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.repositorios.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired  //Inyección de dependencias: accede al repositorio para guardar objetos
    private ProductRepository productRepository;
    //Instancia el repositorio automáticamente y lo usa cuando lo necesite

    //Implementaciónd de métodos principales que se usan al entrar en CRUD
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //Objeto de tipo opcional que controla si un objeto existe o no y evitar los null pointer
    //Un null pointer: la dirección de memoria a la que se intenta acceder está vacía
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
        //Devuelve un optional
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);

    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }



}
