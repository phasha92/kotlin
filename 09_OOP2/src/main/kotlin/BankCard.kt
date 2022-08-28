abstract class BankCard {
    protected abstract val name : String
    protected abstract var balance : Balance
    abstract fun replenish(value : Double)
    abstract fun pay(value : Double)
    abstract fun getBalanceInfo()
    protected open fun getAvailableFunds() = println("""
        |
        |Доступные средства: ${String.format("%.2f", balance.debit)} ${grammarBalance(balance.debit)}
        |Кредитные средства: ${String.format("%.2f", balance.credit)} ${grammarBalance(balance.credit)}
    """.trimMargin()
    )

    protected fun grammarBalance(value : Double) : String {
        return when {
            value.toInt().toString()[value.toInt().toString().lastIndex] == '1' -> "рубль"
            value.toInt().toString()[value.toInt().toString().lastIndex] in ('2'..'3') -> "рубля"
            value.toInt().toString()[value.toInt().toString().lastIndex] in ('4'..'9') -> "рублей"
            else -> "рублей"
        }
    }
}