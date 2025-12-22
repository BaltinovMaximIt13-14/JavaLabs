package com.production.ozonproduction.service;

import com.production.ozonproduction.entity.Material;
import com.production.ozonproduction.repository.MaterialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервисный класс для бизнес-логики материалов.
 * Обеспечивает операции CRUD для материалов.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @service Сервисный слой для работы с материалами
 */
@Service
public class MaterialService {

  private final MaterialRepository materialRepository;

  @Autowired
  public MaterialService(MaterialRepository materialRepository) {
    this.materialRepository = materialRepository;
  }

  /**
   * Получить все материалы
   */
  public List<Material> getAllMaterials() {
    return materialRepository.findAll();
  }

  /**
   * Получить материал по ID
   */
  public Material getMaterialById(Long id) {
    return materialRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Материал не найден: " + id));
  }

  /**
   * Сохранить новый материал
   */
  @Transactional
  public Material saveMaterial(Material material) {
    return materialRepository.save(material);
  }

  /**
   * Обновить материал
   */
  @Transactional
  public Material updateMaterial(Long id, Material materialDetails) {
    Material material = getMaterialById(id);
    material.setMaterialType(materialDetails.getMaterialType());
    material.setMaterialColor(materialDetails.getMaterialColor());
    return materialRepository.save(material);
  }

  /**
   * Удалить материал
   */
  @Transactional
  public void deleteMaterial(Long id) {
    Material material = getMaterialById(id);
    materialRepository.delete(material);
  }
}