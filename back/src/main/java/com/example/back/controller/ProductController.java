package com.example.back.controller;

import com.example.back.dao.ProductDao;
import com.example.back.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:3000/")
public class ProductController {
@Autowired
    private ProductDao productDao;
    @PostMapping("/addProduct")
    public String saveProduct(@RequestBody Product product){
        return productDao.addProduct(product);
    }

    @GetMapping("/display")
    public List<Product>getData(){
        return productDao.getAll();
    }

   @PutMapping("/update")
    public String updateDate(@RequestBody Product product){

        productDao.editProduct(product);
        return "edit sucessfully";
   }
   @DeleteMapping("/delete/{id}")
    public String deleteProduct(@RequestBody Product id){
        productDao.deleteProduct(id);
        return "delete successfully";
   }
}
