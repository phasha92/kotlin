sealed class MediumSizedGoods: Product() {
    data class SystemBlock(override val weight: Int = 5, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        override fun toString() = "Системный блок $weight"
    }

    data class Monitor(override val weight: Int = 2, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        override fun toString() = "Монитор $weight"
    }

    data class Chair(override val weight: Int = 2, override val loadingTime: Long = 1000L): MediumSizedGoods() {
        override fun toString() = "Стул $weight"
    }

    data class TV(override val weight: Int = 5, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        override fun toString() = "Телевизор $weight"
    }

    data class Notebook(override val weight: Int = 3, override val loadingTime: Long = 3000L): MediumSizedGoods() {
        override fun toString() = "Ноутбук $weight"
    }

    companion object {
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