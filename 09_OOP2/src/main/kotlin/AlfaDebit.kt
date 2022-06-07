class AlfaDebit(debit : Double) : DebitCard(debit) {
    //процент на пополнение

    override  val name = "\n\nAlfabank DebitCard:"

    override var balance = Balance(debit)

    private val percentReplenish = 1.01

    override fun replenish(value : Double) {
        println("\nВы пополнили баланс на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
        super.replenish(value)
        println("\nВам начислен бонус от суммы пополнения в размере 1%: ${
            String.format("%.2f",
                value * percentReplenish - value)
        } ${grammarBalance(value * percentReplenish - value)}")
        super.replenish(value * percentReplenish - value)
    }
}