sealed class Appliances: Product() {
    data class SystemBlock(val weight: Int = 5, val loadingTime: Long = 3000L): Appliances() {
        override fun toString() = "Системный блок ${weight}кг"
    }

    data class Monitor(val weight: Int = 2, val loadingTime: Long = 3000L): Appliances() {
        override fun toString() = "Монитор ${weight}кг"
    }

    data class Smartphone(val weight: Int = 1, val loadingTime: Long = 1000L): Appliances() {
        override fun toString() = "Смартфон ${weight}кг"
    }

    data class AirConditioner(val weight: Int = 10, val loadingTime: Long = 3000L): Appliances() {
        override fun toString() = "Кондиционер ${weight}кг"
    }

    data class Fan(val weight: Int = 1, val loadingTime: Long = 3000L): Appliances() {
        override fun toString() = "Вентилятор ${weight}кг"
    }

    data class TV(val weight: Int = 8, val loadingTime: Long = 3000L): Appliances() {
        override fun toString() = "Телевизор ${weight}кг"
    }

    data class Notebook(val weight: Int = 3, val loadingTime: Long = 3000L): Appliances() {
        override fun toString() = "Ноутбук ${weight}кг"
    }
}
