package com.production.ozonproduction.service;

import com.production.ozonproduction.entity.ProductionBatch;
import com.production.ozonproduction.repository.ProductionBatchRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервисный класс для бизнес-логики производственных партий.
 * Обеспечивает операции CRUD для производственных партий.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @service Сервисный слой для работы с производственными партиями
 */
@Service
public class ProductionBatchService {

  private final ProductionBatchRepository batchRepository;

  @Autowired
  public ProductionBatchService(ProductionBatchRepository batchRepository) {
    this.batchRepository = batchRepository;
  }

  /**
   * Получить все производственные партии
   */
  public List<ProductionBatch> getAllBatches() {
    return batchRepository.findAll();
  }

  /**
   * Получить партию по ID
   */
  public ProductionBatch getBatchById(Long id) {
    return batchRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Партия не найдена: " + id));
  }

  /**
   * Сохранить новую партию
   */
  @Transactional
  public ProductionBatch saveBatch(ProductionBatch batch) {
    return batchRepository.save(batch);
  }

  /**
   * Обновить партию
   */
  @Transactional
  public ProductionBatch updateBatch(Long id, ProductionBatch batchDetails) {
    ProductionBatch batch = getBatchById(id);
    batch.setProductionDate(batchDetails.getProductionDate());
    batch.setProduct(batchDetails.getProduct());
    batch.setMaterial(batchDetails.getMaterial());
    batch.setBatchQuantity(batchDetails.getBatchQuantity());
    batch.setMaterialConsumptionG(batchDetails.getMaterialConsumptionG());
    return batchRepository.save(batch);
  }

  /**
   * Удалить партию
   */
  @Transactional
  public void deleteBatch(Long id) {
    ProductionBatch batch = getBatchById(id);
    batchRepository.delete(batch);
  }
}