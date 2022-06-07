abstract class CreditCard(debit : Double, credit : Double) : BankCard() {
    override var balance = Balance(debit, credit)
    override val name : String
        get() = ""

    protected open val maxCredit = 10000.0

    override fun replenish(value : Double) {
        if (balance.credit + value <= maxCredit)
            balance.credit += value
        else {
            balance.debit += value + balance.credit - maxCredit
            balance.credit = maxCredit
        }
    }

    override fun pay(value : Double) {
        if (value <= balance.debit + balance.credit) {
            print("\nВы совершили покупку на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
            if (balance.debit - value >= 0)
                balance.debit -= value
            else {
                balance.credit -= value - balance.debit
                balance.debit = 0.0
            }
        } else println("\nДля совершения сделки недостаточно средств!")
    }

    override fun getBalanceInfo() {
        getAvailableFunds()
    }


}