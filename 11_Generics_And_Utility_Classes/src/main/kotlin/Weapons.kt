

object Weapons {
    fun createPistol() = object : AbstractWeapon() {
        override val maxCountAmmo : Int
            get() = 7
        override val fireType : FireType
            get() = FireType.Shot
    }
    fun createAutomate() = object : AbstractWeapon() {
        override val maxCountAmmo : Int
            get() = 35
        override val fireType : FireType
            get() = FireType.MultiShot()
    }
    fun createShotGun() = object : AbstractWeapon() {
        override val maxCountAmmo : Int
            get() = 8
        override val fireType : FireType
            get() = FireType.AllShot
    }
    fun createRifle() = object : AbstractWeapon() {
        override val maxCountAmmo : Int
            get() = 7
        override val fireType : FireType
            get() = FireType.SniperShot
    }
    fun createPistolRandom() = object : AbstractWeapon() {
        override val maxCountAmmo : Int
            get() = 12
        override val fireType : FireType
            get() = FireType.RandomShot
    }
}