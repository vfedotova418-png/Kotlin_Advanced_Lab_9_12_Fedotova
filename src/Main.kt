import example.GameHero
import example.InstantMessenger
import example.SmartPhone
import example.UserProfile
import modules.EnergyGenerator
import modules.ModuleResult
import modules.ResearchLab
import outpostState.OutpostManager
import resources.OutpostResource
import resources.ResourceManager
import kotlin.properties.Delegates

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println(
                "Недостаточно ресурса ${result.resourceName}. " +
                "Нужно ${result.required}, есть: ${result.available}"
            )
        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}")
    }
}

var counter: Int by Delegates.observable(0) { _, old, new ->
    println("Счётчик изменился: $old -> $new")
}

class User {
    var name: String by Delegates.observable("<no name>") { _, old, new ->
        println("Имя изменено: '$old' -> '$new'")
    }
}

object SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }

    fun log(message: String) {
        println("[LOG] $message")
    }
}

val logger by lazy {
    SystemLogger
}

fun main() {
    val manager = resources.ResourceManager()
    val minerals = OutpostResource(1, "Minerals", 300)
    val gas = OutpostResource(2, "Gas", 100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amountInit = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")
    val manager1 = ResourceManager()
    manager1.add(OutpostResource(1, "Minerals", 120))
    manager1.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager1.printAll()
    val max = InstantMessenger("MAX")
//    val photoCamera = PhotoCamera()
    val yotaPhone = SmartPhone("YotaPhone ", max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    counter = 1
    counter = 5
    println("Создаём профиль пользователя...")
    val user = UserProfile("Алиса", "alice@example.com")

    println("\nИмя: ${user.name}")
    println("Email: ${user.email}")

    println("\nОбращаемся к аватару впервые:")
    println("Файл аватара: ${user.avatar}")

    println("\nОбращаемся к аватару снова (должен быть взят из кэше):")
    println("Файл аватара: ${user.avatar}")

    println("\nМеняем email:")
    user.email = "vfedotova418@gmail.com"

    println("\nМеняем имя:")
    user.name = "Helel P."
    println("Создаём героя...")
    val hero = GameHero("Воин Света")

    println("\nТекущая мана: ${hero.mana}")

    println("\nГерой пытается использовать способность:")
    println("Способность: ${hero.ultimate}")

    println("\nПовторный вызов способности (должна быть мгновенной):")
    println("Способность: ${hero.ultimate}")

    println("\nМеняем имя героя:")
    hero.name = "Тёмный Паладин"

    println("\nГерой восстанавливает ману:")
    hero.mana = 200
    logger.log("Запуск базы")
    val loadedResources = FileStorage.load()
    loadedResources.forEach { manager.add(it) }
    if (loadedResources.isEmpty()) {
        manager.add(OutpostResource(1, "Minerals", 300))
        manager.add(OutpostResource(2, "Gas", 100))
    }
    FileStorage.save(manager.getAll())
    //ДЗ
    val manager2 = OutpostManager()
}