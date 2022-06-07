object Converters {

    private val converterList = listOf(USD(), EUR(), NZD())

    fun get(currencyCode : String) : CurrencyConverter {
        val code = currencyCode.uppercase()
        for (i in converterList.indices)
            if (converterList[i].currencyCode == code) return converterList[i]

        return object : CurrencyConverter {
            override val currencyCode : String? = null
            override fun convertToRub(n : Double) : Double? {
                println("Валюта $code не распознана")
                return null
            }
        }
    }
}