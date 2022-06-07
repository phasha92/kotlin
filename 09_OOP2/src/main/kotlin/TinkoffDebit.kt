class TinkoffDebit(debit : Double) : DebitCard(debit) {
    //кэшбек от покупки
    override val name = "\n\nTinkoffbank DebitCard:"

    override var balance = Balance(debit)

    private val cashBack = 0.05
    private fun cashBackCondition(value : Double) = value >= 5000.0
    private var cashBackBalance = 0.0

    override fun replenish(value : Double) {
        print("\nВы пополнили баланс на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}\n")
        super.replenish(value)
    }

    override fun pay(value : Double) {
        if (balance.debit - value >= 0) {
            super.pay(value)
            if (cashBackCondition(value)) {
                cashBackBalance += value * cashBack
                println("\nВам начислен кэшбек в размере: ${
                    String.format("%.2f",
                        cashBackBalance)
                } ${grammarBalance(cashBackBalance)}")
                replenish(cashBackBalance)
                cashBackBalance = 0.0
            }
        } else println("\nДля совершения сделки недостаточно средств!")
    }
}