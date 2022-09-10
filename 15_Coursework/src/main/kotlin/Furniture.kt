sealed class Furniture: Product() {
    data class Table(val weight: Int = 10, val loadingTime: Long = 3000L): Furniture() {
        override fun toString() = "Стол ${weight}кг"
    }

    data class Chair(val weight: Int = 2, val loadingTime: Long = 1000L): Furniture() {
        override fun toString() = "Стул ${weight}кг"
    }

    data class Sofa(val weight: Int = 25, val loadingTime: Long = 4000L): Furniture() {
        override fun toString() = "Диван ${weight}кг"
    }

    data class Armchair(val weight: Int = 10, val loadingTime: Long = 3000L): Furniture() {
        override fun toString() = "Кресло ${weight}кг"
    }

    data class Bed(val weight: Int = 15, val loadingTime: Long = 3000L): Furniture() {
        override fun toString() = "Кровать ${weight}кг"
    }
}
