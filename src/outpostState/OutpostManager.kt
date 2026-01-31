package outpostState

class OutpostManager {
    val resources by lazy {
        println("Создан Outpost Manager")
        mutableListOf<ObservableResource>()
    }

    fun Add(resource: ObservableResource) {
        resources.add(resource)
    }
}