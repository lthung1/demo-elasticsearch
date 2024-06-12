package com.example.demoelasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Document(indexName = "product_index") // index for elasticsearch
public class Product implements Serializable {
  @Id private String id;

  private String name;
  private int price;
  private String description;


  public String getId() {
    return this.id == null ? UUID.randomUUID().toString() : this.id;
  }
}
