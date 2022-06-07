class TinkoffCredit(debit : Double, credit : Double) : CreditCard(debit, credit) {
    //будет кэшбек
  override  val name = "\n\nTinkoffbank CreditCard:"

    override var balance = Balance(debit, credit)

    override val maxCredit : Double
        get() = super.maxCredit * 3

    private val cashBack = 0.05
    private fun cashBackCondition(value : Double) = value >= 5000.0
    private var cashBackBalance = 0.0

    override fun replenish(value : Double) {
        print("\nВы пополнили баланс на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
        super.replenish(value)
    }

    override fun pay(value : Double) {
        if (value <= balance.debit + balance.credit) {
            println("Вы совершили покупку на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
            if (balance.debit - value >= 0) {
                balance.debit -= value
                if (cashBackCondition(value)) {
                    cashBackBalance += (cashBack * value)
                    println("\nВам начислен кэшбек в размере: ${
                        String.format("%.2f",
                            cashBackBalance)
                    } ${grammarBalance(cashBackBalance)}")
                    replenish(cashBackBalance)
                    cashBackBalance = 0.0

                }
            } else {
                balance.credit -= value - balance.debit
                balance.debit = 0.0
                if (cashBackCondition(value)) {
                    cashBackBalance += value * cashBack
                    println("\nВам начислен кэшбек в размере: ${
                        String.format("%.2f",
                            cashBackBalance)
                    } ${grammarBalance(cashBackBalance)}")
                    replenish(cashBackBalance)
                    cashBackBalance = 0.0
                }
            }
        } else println("\nДля совершения сделки недостаточно средств!")

    }


    }

