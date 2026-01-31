package outpostState

fun OnChange(name: String, old: Int, new: Int){
    println("Обнаружено изменение:")
    println("Ресурс $name изменён: $old -> $new")
}