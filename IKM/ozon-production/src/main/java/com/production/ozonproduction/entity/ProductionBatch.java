package com.production.ozonproduction.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

/**
 * Сущность "Производственная партия" для хранения информации о партиях производства.
 * Связывает таблицы Product и Material (многие-к-одному).
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @entity Сущность базы данных для таблицы production_batches
 */
@Entity
@Table(name = "production_batches")
public class ProductionBatch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "batch_id")
  private Long batchId;

  @Column(name = "production_date", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate productionDate;

  @ManyToOne
  @JoinColumn(name = "product_sku", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "material_id", nullable = false)
  private Material material;

  @Column(name = "batch_quantity", nullable = false)
  private Integer batchQuantity;

  @Column(name = "material_consumption_g", nullable = false)
  private Integer materialConsumptionG;

  public ProductionBatch() {
  }

  public ProductionBatch(LocalDate productionDate, Product product, Material material,
                         Integer batchQuantity, Integer materialConsumptionG) {
    this.productionDate = productionDate;
    this.product = product;
    this.material = material;
    this.batchQuantity = batchQuantity;
    this.materialConsumptionG = materialConsumptionG;
  }

  public Long getBatchId() {
    return batchId;
  }

  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  public LocalDate getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(LocalDate productionDate) {
    this.productionDate = productionDate;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public Integer getBatchQuantity() {
    return batchQuantity;
  }

  public void setBatchQuantity(Integer batchQuantity) {
    this.batchQuantity = batchQuantity;
  }

  public Integer getMaterialConsumptionG() {
    return materialConsumptionG;
  }

  public void setMaterialConsumptionG(Integer materialConsumptionG) {
    this.materialConsumptionG = materialConsumptionG;
  }
}