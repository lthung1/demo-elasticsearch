package com.example.demoelasticsearch.service;

import com.example.demoelasticsearch.entity.Product;
import com.example.demoelasticsearch.repo.ProductElasticRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductElasticRepo productElasticRepo;

  private final ElasticsearchOperations elasticsearchOperations;

  @Cacheable(value = "allProductES", key = "'products'")
  public List<Product> getAllProductsFromElasticSearch(String query) {
    return productElasticRepo.findByNameOrDescription(query, query);
  }

  public void save(Product product) {
    elasticsearchOperations.save(product);
  }
}
