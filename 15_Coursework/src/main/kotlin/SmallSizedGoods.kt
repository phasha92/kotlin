sealed class SmallSizedGoods: Product() {
    override fun toString() = "Мелкий товар"
    data class Smartphone(override val weight: Int = 1, override val loadingTime: Long = 1000L): SmallSizedGoods() {
        override fun toString() = "Смартфон"
    }

    data class Fan(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        override fun toString() = "Вентилятор"
    }

    data class TableLamp(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        override fun toString() = "Настольная лампа"
    }

    data class Dishes(override val weight: Int = 3, override val loadingTime: Long = 10000L): SmallSizedGoods() {
        override fun toString() = "Посуда"
    }

    data class Radio(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        override fun toString() = "Радио приемник"
    }

    companion object {
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