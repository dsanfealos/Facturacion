package com.eoi.Facturacion.repositorios;

import com.eoi.Facturacion.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Creamos el método aquí para que funcione en el ProductService
    //El JpaRepository ya tiene los métodos básicos de CRUD - implementamos el método findByName
    //El JPA nos permite asumir que al crear este método, vamos a crear una Query para buscar algo por el nombre en la BD
    Optional<Product> findByName(String name);
}
