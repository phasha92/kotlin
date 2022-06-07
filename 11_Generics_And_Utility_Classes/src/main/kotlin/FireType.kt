import kotlin.random.Random

sealed class FireType {
    abstract val typeFire : String

    object Shot : FireType() {
        override val typeFire = "Одиночный выстрел "
        override fun toString() : String {
            return "Пистолет"
        }
    }

    data class MultiShot(val countAmmo : Int = 3) : FireType() {
        override val typeFire = "Выстрел очередями\n"
        override fun toString() : String {
            return "Автомат"
        }

    }

    object AllShot : FireType() {
        override val typeFire = "Выстрел дробью\n"
        override fun toString() : String {
            return "Дробовик"
        }
    }

    object SniperShot : FireType() {
        override val typeFire = "Снайперский выстрел "
        override fun toString() : String {
            return "Винтовка"
        }
    }

    object RandomShot : FireType() {
        val randomCount : Int
             get()  = Random.nextInt(2,7)

        override val typeFire = "Случайная очередь\n"
        override fun toString() : String {
            return "Полуавтоматический пистолет"
        }
    }
}
