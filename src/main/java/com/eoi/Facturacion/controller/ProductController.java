package com.eoi.Facturacion.controller;

import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")    //Al ponerlo antes de la clase, todos los métodos de la clase tendrán este prefijo
public class ProductController {

    @Autowired  //No necesitamos crear una instancia de ProductService porque Spring lo hace auto
    private ProductService productService;
    //Para acceder a los métodos avanzados del servicio

    @GetMapping("/")
    public String showProducts(Model model){    //Objeto que Spring utiliza para pasar a la vista (html) los valores o info que queremos
        //Creamos atributo "products" que contiene todos los productos
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
        //Te devuelven un nuevo objeto tipo Producto ya rellenado y para que lo guardes en la BD
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products/";
        //Postear ese producto a la BD
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product-form";
        //La plantilla de form para editar datos
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products/";
    }

}
