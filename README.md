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
git clone https://github.com/vfedotova418-png/Kotlin_Advanced_Lab_9_12_Fedotova.git
```
2. Откройте проект в IntelliJ IDEA.
3. Запустите любой пример через контекстное меню или напрямую из `main`.
## Автор
Федотова
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

# Galaxy Outpost Manager
Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программирования и
архитектурные приёмы языка.
## Sealed-классы
**Sealed-классы** используются для представления ограниченного набора состояний или результатов, которые
известны на этапе компиляции.

Они позволяют:

- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию when без else;
- удобно описывать состояния, события и результаты действий.
### Пример: результат работы модуля
``` Kotlin
sealed-class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}
```
## Object в Kotlin
**object** — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).

Особенности:

- создаётся при первом обращении;
- существует в одном экземпляре;
- не имеет конструктора.

### Пример: глобальный логгер
``` Kotlin
object Logger {
    private var counter = 0
    fun log(message: String) {
        counter++
        println("[$counter] $message")
    }
}
```

### Использование:
``` Kotlin
Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
```

**object** удобно использовать для:
- логгеров;
- конфигураций;
- состояний без данных в sealed-классах;
- утилитарных классов.