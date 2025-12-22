package com.production.ozonproduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения Spring Boot.
 * Запускает веб-приложение для управления производством.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @springBootApplication Основной класс приложения Spring Boot
 */
@SpringBootApplication
public class OzonProductionApplication {
  public static void main(String[] args) {
    SpringApplication.run(OzonProductionApplication.class, args);
  }
}