package com.production.ozonproduction.service;

import com.production.ozonproduction.entity.Product;
import com.production.ozonproduction.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервисный класс для бизнес-логики товаров.
 * Обеспечивает операции CRUD для товаров.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @service Сервисный слой для работы с товарами
 */
@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /**
   * Получить все товары
   */
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  /**
   * Получить товар по артикулу
   */
  public Product getProductBySku(String sku) {
    return productRepository.findById(sku)
        .orElseThrow(() -> new RuntimeException("Товар не найден: " + sku));
  }

  /**
   * Сохранить новый товар
   */
  @Transactional
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  /**
   * Обновить товар
   */
  @Transactional
  public Product updateProduct(String sku, Product productDetails) {
    Product product = getProductBySku(sku);
    product.setProductName(productDetails.getProductName());
    product.setProductWeightG(productDetails.getProductWeightG());
    return productRepository.save(product);
  }

  /**
   * Удалить товар
   */
  @Transactional
  public void deleteProduct(String sku) {
    Product product = getProductBySku(sku);
    productRepository.delete(product);
  }
}