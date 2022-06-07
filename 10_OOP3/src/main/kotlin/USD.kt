import kotlin.math.floor

class USD : CurrencyConverter {
    override val currencyCode : String
        get() = "USD"

    override fun convertToRub(n : Double) : Double {
        val convert = floor((n / 71.1) * 100) / 100
        println("$n RUB convert to USD = $convert")
        return convert
    }
}