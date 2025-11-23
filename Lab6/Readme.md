
# Отчет по лабораторной работе

Лабораторную работу выполнил Балтинов М. А. Ит-13,14-24

## Основные классы:

- **Main** - Главный класс программы, содержащий точку входа и меню для выбора заданий
- **Test** - Класс для тестирования функциональности, содержит методы для выполнения восьми различных заданий, связанных с аннотациями и их обработкой
- **Validator** - Вспомогательный класс для валидации пользовательского ввода различных типов данных
- **AnnotationUtil** (в пакете Cache) - Утилита для работы с аннотациями @Cache и @Invoke
- **SimpleCache** (в пакете Cache) - Минимальная реализация кэша для тестирования
- **ToStringUtils** (в пакете ToString) - Универсальная утилита для формирования строкового представления объектов на основе @ToString

## Сущности:

### Аннотации и обработчики для кэширования (ru.baltinov.Cache):

- **Cache** - Аннотация для указания кэшируемых областей:
  <ul>
  <li>Цель: TYPE</li>
  <li>Retention: RUNTIME</li>
  <li>Свойство value: массив строк (по умолчанию пустой)</li>
  </ul>

- **CacheInvokeDemo** - Демонстрационный класс с @Cache и методом с @Invoke

- **EmptyCacheDemo** - Класс с пустым @Cache для тестирования

- **CacheProcessor** - Обработчик для аннотации @Cache, выводит области кэширования

- **AnnotationUtil** - Утилита: получает области из @Cache и вызывает методы с @Invoke

- **SimpleCache** - Минимальный кэш на базе HashMap для имитации кэширования

### Аннотации по умолчанию (ru.baltinov.Default):

- **Default** - Аннотация для указания типа по умолчанию:
  <ul>
  <li>Цель: TYPE, FIELD</li>
  <li>Retention: RUNTIME</li>
  <li>Свойство value: Class</li>
  </ul>

- **DefaultDemo** - Демонстрационный класс с @Default на классе и поле

- **DefaultProcessor** - Обработчик, выводит типы по умолчанию для класса и полей

### Автоматический вызов методов (ru.baltinov.Invoke):

- **Invoke** - Аннотация для автоматического вызова методов:
  <ul>
  <li>Цель: METHOD</li>
  <li>Retention: RUNTIME</li>
  <li>Без свойств</li>
  </ul>

- **InvokeDemo** - Демонстрационный класс с методами, помеченными @Invoke

- **InvokeProcessor** - Обработчик, находит и вызывает методы с @Invoke через Reflection

### Строковое представление объектов (ru.baltinov.ToString):

- **Mode** - Enum для режимов аннотации (YES, NO)

- **ToString** - Аннотация для управления toString():
  <ul>
  <li>Цель: TYPE, FIELD</li>
  <li>Retention: RUNTIME</li>
  <li>Свойство value: Mode (по умолчанию YES)</li>
  </ul>

- **ToStringDemo** - Демонстрационный класс с полями, аннотированными @ToString

- **ToStringProcessor** - Обработчик для генерации toString() на основе аннотаций

- **ToStringUtils** - Утилита для формирования toString(), анализа полей и списков включенных/исключенных полей

### Аннотация с двумя свойствами (ru.baltinov.Two):

- **Two** - Аннотация с двумя обязательными свойствами:
  <ul>
  <li>Цель: TYPE</li>
  <li>Retention: RUNTIME</li>
  <li>Свойства: first (String), second (int)</li>
  </ul>

- **TwoDemo** - Демонстрационный класс с @Two

- **TwoProcessor** - Обработчик, выводит значения свойств аннотации

### Валидация типов (ru.baltinov.Validate):

- **Validate** - Аннотация для указания типов для валидации:
  <ul>
  <li>Цель: TYPE, ANNOTATION_TYPE</li>
  <li>Retention: RUNTIME</li>
  <li>Свойство value: Class[]</li>
  </ul>

- **ValidateDemo** - Демонстрационный класс с @Validate

- **ValidateProcessor** - Обработчик, выводит список классов для валидации

### Тесты (test.ru.baltinov.Cache и test.ru.baltinov.ToString):

- **CacheInvokeTest** - JUnit-тесты для @Cache и @Invoke: проверка областей, вызов методов, интеграция с кэшем

- **AbstractToStringTest** - Абстрактный базовый класс для тестов @ToString

- **ToStringDemoTest** - Конкретные тесты для ToStringDemo: проверка включения/исключения полей в toString()

-----

## Задание 1: Аннотация @Invoke

Разработана аннотация @Invoke для методов, доступная в runtime. Обработчик через Reflection находит и вызывает аннотированные методы. Демонстрируется автоматический вызов методов в классе InvokeDemo, включая приватные и с параметрами (с дефолтными значениями).<br>
<img width="763" height="172" alt="image" src="https://github.com/user-attachments/assets/1145c6f4-5cc2-4f65-83d6-9509ef31f52f" />
<br>

## Задание 2: Аннотация @Default

Аннотация @Default для типов и полей с свойством value (Class). Обработчик выводит типы по умолчанию для класса и полей. Демонстрируется на классе DefaultDemo с аннотациями на классе и поле.<br>
<img width="652" height="158" alt="image" src="https://github.com/user-attachments/assets/8d236cf9-1839-406a-991b-6826b699a136" />
<br>

## Задание 3: Аннотация @ToString

Аннотация @ToString с режимами YES/NO для классов и полей. Утилита формирует toString(), включая только поля с YES или без аннотации. Демонстрируется на ToStringDemo, где поля password и salary исключены.<br>
<img width="768" height="132" alt="image" src="https://github.com/user-attachments/assets/e4f58177-038e-4511-a55c-990a4839cdec" />
<br>

## Задание 4: Аннотация @Validate

Аннотация @Validate с массивом классов для валидации. Обработчик выводит список типов. Демонстрируется на ValidateDemo с типами String, Integer, Double.<br>
<img width="545" height="228" alt="image" src="https://github.com/user-attachments/assets/9d0306df-ed02-4a25-9de0-7df26b443ae7" />
<br>

## Задание 5: Аннотация @Two

Аннотация @Two с обязательными свойствами first (String) и second (int). Обработчик выводит значения. Демонстрируется на TwoDemo с значениями "Hello" и 12.<br>
<img width="465" height="198" alt="image" src="https://github.com/user-attachments/assets/726f7777-ddde-400d-ab33-dafe54b2179b" />
<br>

## Задание 6: Аннотация @Cache

Аннотация @Cache с массивом строк для областей кэширования (по умолчанию пустой). Обработчик выводит список или сообщение о пустоте. Демонстрируется на CacheInvokeDemo и EmptyCacheDemo.<br>
<img width="503" height="321" alt="image" src="https://github.com/user-attachments/assets/c48aed2c-93d6-4335-92e5-63f5b3c065c3" />
<br>

## Задание 7: Тестирование @ToString с JUnit

JUnit-тесты проверяют, что toString() включает поля с @ToString(Mode.YES) или без аннотации и исключает с Mode.NO. Используется абстрактный класс и конкретный тест для ToStringDemo.<br>
<img width="805" height="474" alt="image" src="https://github.com/user-attachments/assets/8a48de73-359c-4108-b692-a503d41c35ea" />
<br>

## Задание 8: Тестирование @Cache и @Invoke с JUnit

JUnit-тесты проверяют совместную работу аннотаций: получение областей из @Cache, вызов методов с @Invoke, интеграцию с простым кэшем. Проверяется пустой кэш и добавление в кэш для непустых областей.<br>
Тест: Вывод показывает области ["users", "orders"], вызов 1 метода, данные в кэше; для пустого - 0 областей, вызов метода без кэширования.<br>
<img width="478" height="501" alt="image" src="https://github.com/user-attachments/assets/4b643551-7772-4738-9f68-499c0e4506d6" />
<br>
