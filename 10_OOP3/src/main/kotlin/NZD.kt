import kotlin.math.floor

class NZD : CurrencyConverter {
    override val currencyCode : String
        get() = "NZD"

    override fun convertToRub(n : Double) : Double {
        val convert = floor((n / 50.99) * 100) / 100
        println("$n RUB convert to NZD = $convert")
        return convert
    }
}