sealed class SmallSizedGoods: Product() {
    data class Smartphone(override val weight: Int = 1, override val loadingTime: Long = 1000L): SmallSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Смартфон #$productNumber"
    }

    data class Fan(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Вентилятор #$productNumber"
    }

    data class TableLamp(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Настольная лампа #$productNumber"
    }

    data class Dishes(override val weight: Int = 3, override val loadingTime: Long = 1000L): SmallSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Посуда #$productNumber"
    }

    data class Radio(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Радио приемник #$productNumber"
    }

    companion object {
        private var count = 0
        fun createSmallSizedGoods() =
            listOf(
                Smartphone(),
                Fan(),
                TableLamp(),
                Dishes(),
                Radio()
            ).random()
    }
}