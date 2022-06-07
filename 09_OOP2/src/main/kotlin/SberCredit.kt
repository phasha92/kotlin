class SberCredit(debit : Double, credit : Double) : CreditCard(debit, credit) {
//будут бонусные баллы
   override val name = "\n\nSberbank CreditCard:"

    override var balance = Balance(debit, credit)

    override val maxCredit : Double
        get() = super.maxCredit * 2

    private val bonusBalls = 0.05
    private var bonusBallsBalance = 0

    override fun replenish(value : Double) {
        println("\nВы пополнили баланс на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
        super.replenish(value)
        bonusBallsBalance += (bonusBalls * value).toInt()
        println("\nВам начислены бонусные баллы в размере: $bonusBallsBalance")
    }

    override fun getBalanceInfo() {
        super.getAvailableFunds()
        println("Бонусы: $bonusBallsBalance баллов")
    }
}