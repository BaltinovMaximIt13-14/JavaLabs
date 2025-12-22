package com.production.ozonproduction.controller;

import com.production.ozonproduction.entity.Product;
import com.production.ozonproduction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
 * Контроллер для управления товарами.
 * Обеспечивает CRUD операции через веб-интерфейс.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @controller Обрабатывает HTTP-запросы для товаров
 */
@Controller
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Отображение списка всех товаров
   */
  @GetMapping
  public String listProducts(Model model) {
    List<Product> products = productService.getAllProducts();
    model.addAttribute("products", products);
    return "products/list";
  }

  /**
   * Отображение формы добавления нового товара
   */
  @GetMapping("/new")
  public String showAddForm(Model model) {
    model.addAttribute("product", new Product());
    return "products/form";
  }

  /**
   * Сохранение нового товара
   */
  @PostMapping("/save")
  public String saveProduct(@ModelAttribute Product product,
                            RedirectAttributes redirectAttributes) {
    productService.saveProduct(product);
    redirectAttributes.addFlashAttribute("successMessage", "Товар успешно добавлен!");
    return "redirect:/products";
  }

  /**
   * Отображение формы редактирования товара
   */
  @GetMapping("/edit/{sku}")
  public String showEditForm(@PathVariable String sku, Model model) {
    Product product = productService.getProductBySku(sku);
    model.addAttribute("product", product);
    return "products/form";
  }

  /**
   * Обновление товара
   */
  @PostMapping("/update/{sku}")
  public String updateProduct(@PathVariable String sku,
                              @ModelAttribute Product product,
                              RedirectAttributes redirectAttributes) {
    productService.updateProduct(sku, product);
    redirectAttributes.addFlashAttribute("successMessage", "Товар успешно обновлен!");
    return "redirect:/products";
  }

  /**
   * Удаление товара
   */
  @GetMapping("/delete/{sku}")
  public String deleteProduct(@PathVariable String sku,
                              RedirectAttributes redirectAttributes) {
    productService.deleteProduct(sku);
    redirectAttributes.addFlashAttribute("successMessage", "Товар успешно удален!");
    return "redirect:/products";
  }
}