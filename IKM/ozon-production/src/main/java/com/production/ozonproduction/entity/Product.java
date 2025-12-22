package com.production.ozonproduction.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность "Товар" для хранения информации о товарах для продажи на Ozon.
 * Связана с ProductionBatch через отношение один-ко-многим.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @entity Сущность базы данных для таблицы products
 */
@Entity
@Table(name = "products")
public class Product {

  @Id
  @Column(name = "product_sku", length = 50)
  private String productSku;

  @Column(name = "product_name", nullable = false, length = 200)
  private String productName;

  @Column(name = "product_weight_g", nullable = false)
  private Integer productWeightG;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<ProductionBatch> batches = new ArrayList<>();

  public Product() {
  }


  public String getProductSku() {
    return productSku;
  }

  public void setProductSku(String productSku) {
    this.productSku = productSku;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getProductWeightG() {
    return productWeightG;
  }

  public void setProductWeightG(Integer productWeightG) {
    this.productWeightG = productWeightG;
  }

  public List<ProductionBatch> getBatches() {
    return batches;
  }

  public void setBatches(List<ProductionBatch> batches) {
    this.batches = batches;
  }
}