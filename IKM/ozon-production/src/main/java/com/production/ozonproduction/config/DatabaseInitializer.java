package com.production.ozonproduction.config;

import com.production.ozonproduction.entity.*;
import com.production.ozonproduction.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Класс для инициализации базы данных тестовыми данными.
 * Автоматически запускается при старте приложения.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @configuration Класс конфигурации для инициализации БД
 */
@Configuration
public class DatabaseInitializer {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private MaterialRepository materialRepository;

  @Autowired
  private ProductionBatchRepository batchRepository;

  /**
   * Метод инициализации базы данных.
   * Создает тестовые данные для демонстрации работы приложения.
   */
  @PostConstruct
  @Transactional
  public void initDatabase() {
    // Очищаем базу данных
    batchRepository.deleteAll();
    productRepository.deleteAll();
    materialRepository.deleteAll();

    // Создаем тестовые товары
    Product product1 = new Product();
    product1.setProductSku("12345678");
    product1.setProductName("Держатель для ключей 'Кошка'");
    product1.setProductWeightG(30);

    Product product2 = new Product();
    product2.setProductSku("87654321");
    product2.setProductName("Ваза 'Амстердам'");
    product2.setProductWeightG(150);

    Product product3 = new Product();
    product3.setProductSku("55555555");
    product3.setProductName("Шахматная фигура 'Слон'");
    product3.setProductWeightG(50);

    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.save(product3);

    // Создаем тестовые материалы
    Material material1 = new Material();
    material1.setMaterialType("PLA");
    material1.setMaterialColor("Красный");

    Material material2 = new Material();
    material2.setMaterialType("PETG");
    material2.setMaterialColor("Прозрачный");

    Material material3 = new Material();
    material3.setMaterialType("TPU");
    material3.setMaterialColor("Черный");

    materialRepository.save(material1);
    materialRepository.save(material2);
    materialRepository.save(material3);

    // Создаем тестовые производственные партии
    ProductionBatch batch1 = new ProductionBatch();
    batch1.setProductionDate(LocalDate.of(2024, 5, 15));
    batch1.setProduct(product1);
    batch1.setMaterial(material1);
    batch1.setBatchQuantity(40);
    batch1.setMaterialConsumptionG(35);

    ProductionBatch batch2 = new ProductionBatch();
    batch2.setProductionDate(LocalDate.of(2024, 5, 16));
    batch2.setProduct(product2);
    batch2.setMaterial(material2);
    batch2.setBatchQuantity(25);
    batch2.setMaterialConsumptionG(165);

    ProductionBatch batch3 = new ProductionBatch();
    batch3.setProductionDate(LocalDate.of(2024, 5, 17));
    batch3.setProduct(product3);
    batch3.setMaterial(material3);
    batch3.setBatchQuantity(15);
    batch3.setMaterialConsumptionG(55);

    batchRepository.save(batch1);
    batchRepository.save(batch2);
    batchRepository.save(batch3);

    System.out.println("   База данных успешно инициализирована тестовыми данными!");
    System.out.println("   Создано товаров: 3");
    System.out.println("   Создано материалов: 3");
    System.out.println("   Создано производственных партий: 3");
  }
}