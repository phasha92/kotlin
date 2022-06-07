import kotlin.math.floor

class EUR : CurrencyConverter {
    override val currencyCode : String
        get() = "EUR"

    override fun convertToRub(n : Double) : Double {
        val convert = floor((n / 81.5) * 100) / 100
        println("$n RUB convert to EUR = $convert")
        return convert
    }
}