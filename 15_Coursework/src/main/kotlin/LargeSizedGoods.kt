sealed class LargeSizedGoods: Product() {
    data class Table(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        override fun toString() = "Стол"
    }

    data class Fridge(override val weight: Int = 30, override val loadingTime: Long = 30000L): LargeSizedGoods() {
        override fun toString() = "Холодильник"
    }

    data class Sofa(override val weight: Int = 25, override val loadingTime: Long = 25000L): LargeSizedGoods() {
        override fun toString() = "Диван"
    }

    data class Armchair(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        override fun toString() = "Кресло"
    }

    data class Bed(override val weight: Int = 15, override val loadingTime: Long = 5000L): LargeSizedGoods() {
        override fun toString() = "Кровать"
    }

    data class AirConditioner(override val weight: Int = 10, override val loadingTime: Long = 3000L):
        LargeSizedGoods() {
        override fun toString() = "Кондиционер"
    }

    data class Locker(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        override fun toString() = "Шкаф"
    }

    companion object {
        fun createLargeSizedGoods() =
            listOf(
                Table(),
                Fridge(),
                Sofa(),
                Armchair(),
                Bed(),
                AirConditioner(),
                Locker()
            ).random()
    }
}