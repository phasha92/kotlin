abstract class DebitCard(debit : Double) : BankCard() {

    override val name : String
        get() = ""

    override var balance = Balance(debit)

    override fun replenish(value : Double) {

        balance.debit += value
    }

    override fun pay(value : Double) {
        if (value < balance.debit) {
            println("\nВы совершили покупку на сумму: ${String.format("%.2f", value)} ${grammarBalance(value)}")
            balance.debit -= value
        } else
            println("\nДля совершения покупки недостаточно средств!")
    }

    override fun getBalanceInfo() {
        println("Ваш баланс составляет: ${String.format("%.2f", balance.debit)} ${grammarBalance(balance.debit)}")
    }
}