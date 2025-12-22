package com.production.ozonproduction.repository;

import com.production.ozonproduction.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей материалов.
 * Наследует JpaRepository для получения стандартных CRUD операций.
 *
 * @author Baltinov
 * @version 1.0
 * @since 2025
 * @repository Интерфейс доступа к данным для материалов
 */
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}