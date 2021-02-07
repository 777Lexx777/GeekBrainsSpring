package ru.lex.example.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lex.example.spring.model.Product;
import ru.lex.example.spring.persist.ProductRepository;


@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;
    private final Product product;

    @Autowired
    public ProductController(ProductRepository productRepository, Product product) {
        this.productRepository = productRepository;
        this.product = product;
    }

    @GetMapping
    public String listAllProducts(Model model) {
        logger.info("List page requested");

        model.addAttribute("allProducts", productRepository.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        logger.info("Edit page for id {} requested", id);

        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @PostMapping("/update")
    public String update(Product product) {
        logger.info("Update endpoint requested");

        if (product.getId() != -1) {
            logger.info("Updating user with id {}", product.getId());
            productRepository.update(product);
        } else {
            logger.info("Creating new product");
            productRepository.insert(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String newProducts( @ModelAttribute("newProduct") Product product){
        return "newProduct";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newProduct") Product product) {
        // TODO
        logger.info("New product");
        if (product.getId() != -1) {
            logger.info("Updating product with id {}", product.getId());
                //Foo value = productRepository.getProductMap(key);
                if (productRepository.getProductMap().containsKey(product.getId())) {
                    System.out.println("такой ай ди существует");
                } else {
                    productRepository.insert(product);
                }
        } else {
            logger.info("A user with such id already exist");

        }
        return "redirect:/product";
    }

    @DeleteMapping("/{id}/delete")
    public String remove(@PathVariable("id") Long id) {
        // TODO
        productRepository.deleteProduct(id);
        return "redirect:/product";
    }
}
