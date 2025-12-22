package com.production.ozonproduction.controller;

import com.production.ozonproduction.entity.Material;
import com.production.ozonproduction.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
 * Контроллер для управления материалами.
 * Обеспечивает CRUD операции через веб-интерфейс.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @controller Обрабатывает HTTP-запросы для материалов
 */
@Controller
@RequestMapping("/materials")
public class MaterialController {

  private final MaterialService materialService;

  @Autowired
  public MaterialController(MaterialService materialService) {
    this.materialService = materialService;
  }

  /**
   * Отображение списка всех материалов
   */
  @GetMapping
  public String listMaterials(Model model) {
    List<Material> materials = materialService.getAllMaterials();
    model.addAttribute("materials", materials);
    return "materials/list";
  }

  /**
   * Отображение формы добавления нового материала
   */
  @GetMapping("/new")
  public String showAddForm(Model model) {
    model.addAttribute("material", new Material());
    return "materials/form";
  }

  /**
   * Сохранение нового материала
   */
  @PostMapping("/save")
  public String saveMaterial(@ModelAttribute Material material,
                             RedirectAttributes redirectAttributes) {
    materialService.saveMaterial(material);
    redirectAttributes.addFlashAttribute("successMessage", "Материал успешно добавлен!");
    return "redirect:/materials";
  }

  /**
   * Отображение формы редактирования материала
   */
  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Material material = materialService.getMaterialById(id);
    model.addAttribute("material", material);
    return "materials/form";
  }

  /**
   * Обновление материала
   */
  @PostMapping("/update/{id}")
  public String updateMaterial(@PathVariable Long id,
                               @ModelAttribute Material material,
                               RedirectAttributes redirectAttributes) {
    materialService.updateMaterial(id, material);
    redirectAttributes.addFlashAttribute("successMessage", "Материал успешно обновлен!");
    return "redirect:/materials";
  }

  /**
   * Удаление материала
   */
  @GetMapping("/delete/{id}")
  public String deleteMaterial(@PathVariable Long id,
                               RedirectAttributes redirectAttributes) {
    materialService.deleteMaterial(id);
    redirectAttributes.addFlashAttribute("successMessage", "Материал успешно удален!");
    return "redirect:/materials";
  }
}