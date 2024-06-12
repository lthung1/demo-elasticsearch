package com.example.demoelasticsearch;

import com.example.demoelasticsearch.entity.Product;
import com.example.demoelasticsearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
  private final ProductService productService;

  @GetMapping("/es/{query}")
  public List<Product> getAllProductsFromElasticSearch(@PathVariable String query) {
    return productService.getAllProductsFromElasticSearch(query);
  }

  @PostMapping("/es/save")
  public void save(@RequestBody Product product) {
    productService.save(product);
  }
}
