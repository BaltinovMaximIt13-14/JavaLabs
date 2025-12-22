package com.production.ozonproduction.controller;

import com.production.ozonproduction.entity.ProductionBatch;
import com.production.ozonproduction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
 * Контроллер для управления производственными партиями.
 * Обеспечивает CRUD операции через веб-интерфейс.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @controller Обрабатывает HTTP-запросы для производственных партий
 */
@Controller
@RequestMapping("/batches")
public class ProductionBatchController {

  private final ProductionBatchService batchService;
  private final ProductService productService;
  private final MaterialService materialService;

  @Autowired
  public ProductionBatchController(ProductionBatchService batchService,
                                   ProductService productService,
                                   MaterialService materialService) {
    this.batchService = batchService;
    this.productService = productService;
    this.materialService = materialService;
  }

  /**
   * Отображение списка всех производственных партий
   */
  @GetMapping
  public String listBatches(Model model) {
    List<ProductionBatch> batches = batchService.getAllBatches();
    model.addAttribute("batches", batches);
    return "batches/list";
  }

  /**
   * Отображение формы добавления новой партии
   */
  @GetMapping("/new")
  public String showAddForm(Model model) {
    model.addAttribute("batch", new ProductionBatch());
    model.addAttribute("products", productService.getAllProducts());
    model.addAttribute("materials", materialService.getAllMaterials());
    return "batches/form";
  }

  /**
   * Сохранение новой партии
   */
  @PostMapping("/save")
  public String saveBatch(@ModelAttribute ProductionBatch batch,
                          RedirectAttributes redirectAttributes) {
    batchService.saveBatch(batch);
    redirectAttributes.addFlashAttribute("successMessage", "Партия успешно добавлена!");
    return "redirect:/batches";
  }

  /**
   * Отображение формы редактирования партии
   */
  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    ProductionBatch batch = batchService.getBatchById(id);
    model.addAttribute("batch", batch);
    model.addAttribute("products", productService.getAllProducts());
    model.addAttribute("materials", materialService.getAllMaterials());
    return "batches/form";
  }

  /**
   * Обновление партии
   */
  @PostMapping("/update/{id}")
  public String updateBatch(@PathVariable Long id,
                            @ModelAttribute ProductionBatch batch,
                            RedirectAttributes redirectAttributes) {
    batchService.updateBatch(id, batch);
    redirectAttributes.addFlashAttribute("successMessage", "Партия успешно обновлена!");
    return "redirect:/batches";
  }

  /**
   * Удаление партии
   */
  @GetMapping("/delete/{id}")
  public String deleteBatch(@PathVariable Long id,
                            RedirectAttributes redirectAttributes) {
    batchService.deleteBatch(id);
    redirectAttributes.addFlashAttribute("successMessage", "Партия успешно удалена!");
    return "redirect:/batches";
  }
}