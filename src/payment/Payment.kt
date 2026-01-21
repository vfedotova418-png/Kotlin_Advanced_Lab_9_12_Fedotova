package payment

enum class CardType {
    VISA, MASTERCARD, MIR, UNKNOWN
}

sealed class PaymentResult {
    data class Success(val id: String) : PaymentResult()
    data class Error(val reason: String) : PaymentResult()
    object Processing : PaymentResult()
}

data class Payment(
    val card: String,
    val sum: Int,
    val type: CardType = CardType.UNKNOWN
)