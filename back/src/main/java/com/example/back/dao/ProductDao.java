package com.example.back.dao;

import com.example.back.entity.Product;
import com.example.back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product Added Successfully";
    }

    public List<Product> getAll() {
        return productRepository.findAll();

    }

    public Product editProduct(Product product) {
        Product product1=new Product();
        product1.setProd_name(product.getProd_name());
        product1.setPrice(product.getPrice());
        return productRepository.save(product);

    }
    public Product deleteProduct(Product product){
        productRepository.delete(product);
        return productRepository.getReferenceById(product.getId());
    }


}
