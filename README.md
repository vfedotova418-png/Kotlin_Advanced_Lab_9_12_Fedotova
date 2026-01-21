# Лабораторная работа №9-10: Продвинутое ООП на Kotlin
## Описание
Лабораторная работа посвящена изучению продвинутых концепций объектно-ориентированного
программирования в Kotlin.
## Структура проекта
Проект содержит примеры реализации продвинутых механизмов ООП, а также пояснения к ключевым
концепциям.
## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone https://github.com/grehochkag82/Kotlin_Advanced_Lab_9_12_Fedotova_Lobodina.git
```
2. Откройте проект в IntelliJ IDEA.
3. Запустите любой пример через контекстное меню или напрямую из `main`.
## Автор
Федотова и Лободина
## Лицензия
Проект создан в учебных целях
# шаг 16 
1. Геттеры, сеттеры и инкапсуляция
- Использование кастомных геттеров и сеттеров для контроля доступа к свойствам.
- Пример с классом Hero:
```Kotlin

class Hero(val name: String) {
var health: Int = 100
set(value) {
field = value.coerceIn(0..100)
}
}
```
# 1. Date-классы
-Пример OutpostResource:
```Kotlin
data class OutpostResource(val id: Int, val name: String, var amount: Int)
```
# 2. Абстрактные классы
Создание базовой логики для наследников.
Пример OutpostModule:
```Kotlin

abstract class OutpostModule(val name: String, var level: Int = 1) {
abstract fun performAction(manager: ResourceManager)
}
```
# 3. Интерфейсы
Реализация контрактов для классов.
Пример ModuleAction:
```Kotlin

interface ModuleAction {
fun execute(manager: ResourceManager)
}
```