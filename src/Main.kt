import example.InstantMessenger
import example.SmartPhone
import modules.EnergyGenerator
import modules.ModuleResult
import modules.ResearchLab
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

fun main() {
//    val manager = resources.ResourceManager()
//    val minerals = OutpostResource(1, "Minerals", 300)
//    val gas = OutpostResource(2, "Gas", 100)
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом: $bonus")
   val manager = ResourceManager()
   manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
    val max = InstantMessenger("MAX")
//    val photoCamera = PhotoCamera()
    val yotaPhone = SmartPhone("YotaPhone ", max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    counter = 1
    counter = 5
}