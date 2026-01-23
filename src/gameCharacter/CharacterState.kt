package gameCharacter

sealed class CharacterState {
    object Idle : CharacterState()
    object Running : CharacterState()
    data class Attack(val amount: Int) : CharacterState()
    data class Died(val reason: String) : CharacterState()
}