package com.example.demoelasticsearch.repo;

import com.example.demoelasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepo extends ElasticsearchRepository<Product, String> {
  List<Product> findByNameOrDescription(String name, String description);
}
