class SberDebit(debit : Double) : DebitCard(debit) {
    //бонусы
    override  val name = "\n\nSberbank DebitCard:"

    private val bonusBalls = 0.05
    private var bonusBallsBalance = 0

    override var balance = Balance(debit)

    override fun replenish(value : Double) {
        println("\nВы пополнили баланс на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
        super.replenish(value)
        bonusBallsBalance += (bonusBalls * value).toInt()
        println("\nВам начислены бонусные баллы в размере: $bonusBallsBalance")
    }
}