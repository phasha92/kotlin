sealed class MediumSizedGoods: Product() {
    data class SystemBlock(override val weight: Int = 5, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Системный блок #$productNumber"
    }

    data class Monitor(override val weight: Int = 2, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Монитор #$productNumber"
    }

    data class Chair(override val weight: Int = 2, override val loadingTime: Long = 1000L): MediumSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Стул #$productNumber"
    }

    data class TV(override val weight: Int = 5, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Телевизор #$productNumber"
    }

    data class Notebook(override val weight: Int = 3, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Ноутбук #$productNumber"
    }

    companion object {
        private var count = 0
        fun createMediumSizedGoods() =
            listOf(
                SystemBlock(),
                Monitor(),
                Chair(),
                TV(),
                Notebook()
            ).random()
    }
}