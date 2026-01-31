package outpostState

fun main() {
    val manager = OutpostManager()
    println()
    val res1 = ObservableResource("Minerals", 100)
    val res2 = ObservableResource("Gas", 50)
    manager.Add(res1)
    manager.Add(res2)
    manager.resources[0].amount = 200
    manager.resources[1].amount = 100
    StateStorage.Save(manager.resources)
    val loaded = StateStorage.Load()
    loaded.forEach { resource -> println("${resource.resourceName} | ${resource.amount}") }
}