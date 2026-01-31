package outpostState

import kotlin.properties.Delegates

class ObservableResource(
    val resourceName: String,
    val amountInit: Int
) {
    var amount: Int by Delegates.observable(amountInit) { _, old, new ->
//        println("Ресурс $resourceName изменён: $old -> $new")
        OnChange(resourceName, old, new)
    }
}