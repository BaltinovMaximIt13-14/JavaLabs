package com.production.ozonproduction.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность "Материал" для хранения информации о материалах для 3D-печати.
 * Связана с ProductionBatch через отношение один-ко-многим.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @entity Сущность базы данных для таблицы materials
 */
@Entity
@Table(name = "materials")
public class Material {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "material_id")
  private Long materialId;

  @Column(name = "material_type", nullable = false, length = 50)
  private String materialType;

  @Column(name = "material_color", nullable = false, length = 50)
  private String materialColor;

  @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
  private List<ProductionBatch> batches = new ArrayList<>();

  public Material() {
  }

  public Material(String materialType, String materialColor) {
    this.materialType = materialType;
    this.materialColor = materialColor;
  }

  public Long getMaterialId() {
    return materialId;
  }

  public void setMaterialId(Long materialId) {
    this.materialId = materialId;
  }

  public String getMaterialType() {
    return materialType;
  }

  public void setMaterialType(String materialType) {
    this.materialType = materialType;
  }

  public String getMaterialColor() {
    return materialColor;
  }

  public void setMaterialColor(String materialColor) {
    this.materialColor = materialColor;
  }

  public List<ProductionBatch> getBatches() {
    return batches;
  }

  public void setBatches(List<ProductionBatch> batches) {
    this.batches = batches;
  }
}