sealed class SmallSizedGoods: Product() {
    data class Smartphone(override val weight: Int = 1, override val loadingTime: Long = 1000L): SmallSizedGoods() {
        override fun toString() = "Смартфон $weight"
    }

    data class Fan(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        override fun toString() = "Вентилятор $weight"
    }

    data class TableLamp(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        override fun toString() = "Настольная лампа $weight"
    }

    data class Dishes(override val weight: Int = 3, override val loadingTime: Long = 10000L): SmallSizedGoods() {
        override fun toString() = "Посуда $weight"
    }

    data class Radio(override val weight: Int = 1, override val loadingTime: Long = 300L): SmallSizedGoods() {
        override fun toString() = "Радио приемник $weight"
    }
}