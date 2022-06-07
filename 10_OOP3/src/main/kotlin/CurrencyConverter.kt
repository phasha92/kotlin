interface CurrencyConverter {
    val currencyCode : String?
    fun convertToRub(n : Double) : Double?
}