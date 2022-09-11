sealed class LargeSizedGoods: Product() {
    data class Table(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        override fun toString() = "Стол $weight"
    }

    data class Fridge(override val weight: Int = 20, override val loadingTime: Long = 10000L): LargeSizedGoods() {
        override fun toString() = "Холодильник $weight"
    }

    data class Sofa(override val weight: Int = 25, override val loadingTime: Long = 4000L): LargeSizedGoods() {
        override fun toString() = "Диван $weight"
    }

    data class Armchair(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        override fun toString() = "Кресло $weight"
    }

    data class Bed(override val weight: Int = 15, override val loadingTime: Long = 5000L): LargeSizedGoods() {
        override fun toString() = "Кровать $weight"
    }

    data class AirConditioner(override val weight: Int = 10, override val loadingTime: Long = 3000L):
        LargeSizedGoods() {
        override fun toString() = "Кондиционер $weight"
    }

    data class Locker(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        override fun toString() = "Шкаф $weight"
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