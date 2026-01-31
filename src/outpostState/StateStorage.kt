package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "resource_state.txt"

    fun Save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        file.writeText(
            resources.joinToString("\n") {
                "${it.resourceName} | ${it.amount}"
            }
        )
        println("Состояние базы сохранено в файл.")
    }

    fun Load() : List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()
        println("Загрузка состояния базы")
        return file.readLines().map {
            val (name, amount) = it.split(" | ")
            ObservableResource(name, amount.toInt())
        }
    }
}