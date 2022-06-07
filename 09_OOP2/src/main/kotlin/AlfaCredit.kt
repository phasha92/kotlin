class AlfaCredit(debit : Double, credit : Double) : CreditCard(debit, credit) {
//будет процент на пополнение
  override  val name = "\n\nAlfabank CreditCard:"

    override var balance = Balance(debit, credit)

    override val maxCredit
        get() = super.maxCredit * 5

    private val percentReplenish = 1.005

    override fun replenish(value : Double) {
        println("\nВы пополнили баланс на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
        super.replenish(value)
        println("\nВам начислен бонус от суммы пополнения в размере 0,5%: ${
            String.format("%.2f",
                value * percentReplenish - value)
        } ${grammarBalance(value * percentReplenish - value)}")
        super.replenish(value * percentReplenish - value)
    }
}