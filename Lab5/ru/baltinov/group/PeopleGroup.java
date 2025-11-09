package ru.baltinov.group;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleGroup {
  public static Map<Integer, List<String>> processFile(String fileName) throws IOException {
    return Files.lines(Paths.get(fileName))
        //Разделение на имя и номер
        .map(line -> {
          String[] parts = line.split(":");
          String name = parts[0].trim();
          String numberStr;
          if (parts.length > 1){
            numberStr = parts[1].trim();
          } else {
            numberStr = "";
          }
          return new AbstractMap.SimpleEntry<>(name, numberStr);
        })
        //Фильтрация  строк без номера
        .filter(entry -> !entry.getValue().isEmpty())
        //Форматирование на нижний регистр и целый номер
        .map(entry -> new AbstractMap.SimpleEntry<>(
            capitalizeName(entry.getKey().toLowerCase()),
            Integer.parseInt(entry.getValue())
        ))
        //разделение на коллекции
        .collect(Collectors.groupingBy(
            Map.Entry::getValue,
            Collectors.mapping(
                Map.Entry::getKey,
                Collectors.toList()
            )
        ));
  }

  // Метод для преобразования строки к формату с первой заглавной буквой
  private static String capitalizeName(String name) {
    if (name == null || name.isEmpty()) {
      return name;
    }
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

}
