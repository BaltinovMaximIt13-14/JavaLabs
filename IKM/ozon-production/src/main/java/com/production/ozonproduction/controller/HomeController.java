package com.production.ozonproduction.controller;

import com.production.ozonproduction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для главной страницы приложения.
 * Отображает статистику и быстрые ссылки.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @controller Обрабатывает запросы главной страницы
 */
@Controller
public class HomeController {

  private final ProductService productService;
  private final MaterialService materialService;
  private final ProductionBatchService batchService;

  @Autowired
  public HomeController(ProductService productService, MaterialService materialService,
                        ProductionBatchService batchService) {
    this.productService = productService;
    this.materialService = materialService;
    this.batchService = batchService;
  }

  /**
   * Отображение главной страницы
   */
  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("productCount", productService.getAllProducts().size());
    model.addAttribute("materialCount", materialService.getAllMaterials().size());
    model.addAttribute("batchCount", batchService.getAllBatches().size());
    return "index";
  }
}