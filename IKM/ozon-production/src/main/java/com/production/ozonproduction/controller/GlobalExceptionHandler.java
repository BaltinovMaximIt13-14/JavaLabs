package com.production.ozonproduction.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Глобальный обработчик исключений для всего приложения.
 * Перехватывает исключения и показывает пользователю понятные сообщения.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @controllerAdvice Глобальный обработчик исключений
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public String handleRuntimeException(RuntimeException e,
                                       RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("errorMessage",
        "Ошибка: " + e.getMessage());
    return "redirect:/";
  }
}