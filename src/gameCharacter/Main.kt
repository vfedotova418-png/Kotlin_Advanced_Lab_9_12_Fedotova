package gameCharacter

fun handleState(character: GameCharacter) {
    val state = character.state
    when (state) {
        CharacterState.Idle -> println("${character.name} бездействует")
        CharacterState.Running -> println("${character.name} бежит")
        is CharacterState.Attack -> println("${character.name} атакует (нанесено ${state.amount} урона)")
        is CharacterState.Died -> println("${character.name} погиб(ла). Причина: ${state.reason}")
    }
}

fun main() {
    val hero: GameCharacter = GameCharacter("Хорнет")
    handleState(hero)
    hero.changeState(CharacterState.Running)
    handleState(hero)
    hero.changeState(CharacterState.Attack(13))
    handleState(hero)
    hero.changeState(CharacterState.Died("Упала в шипы"))
    handleState(hero)
}