abstract class AbstractWeapon {
   abstract val maxCountAmmo : Int
   abstract val fireType : FireType
    private val magazine : Stack<Ammo> = Stack()
    val isEmpty : Boolean
        get() {
            return magazine.isEmpty()
        }

    private fun getAmmo() : Ammo {
        return when (fireType) {
            is FireType.MultiShot -> Ammo.HARD
            FireType.AllShot -> Ammo.MEDIUM
            FireType.SniperShot -> Ammo.ULTIMATE
            else -> Ammo.SMALL
        }
    }

    fun recharge() {
        for (i in 1..maxCountAmmo)
            magazine.push(getAmmo())
    }

    fun getAmmoForFire() : List<Ammo> {
        val listAmmo = mutableListOf<Ammo>()
        if (magazine.isEmpty()) throw NoAmmoException()
        when (fireType) {
            is FireType.RandomShot -> {
                var countAmmo = 0
                while (countAmmo != (fireType as FireType.RandomShot).randomCount) {
                    listAmmo.add(getAmmoNotNull())
                    countAmmo += 1
                }
            }
            is FireType.MultiShot -> {
                var countAmmo = 0
                while (countAmmo != (fireType as FireType.MultiShot).countAmmo) {
                    listAmmo.add(getAmmoNotNull())
                    countAmmo += 1
                }
            }
            FireType.AllShot -> while (!isEmpty) {
                listAmmo.add(getAmmoNotNull())
            }
            else -> listAmmo.add(getAmmoNotNull())
        }
        return listAmmo
    }

    private fun getAmmoNotNull() : Ammo {
        val ammo = magazine.pop()
        // print("${fireType.type}")
        return checkNotNull(ammo)
    }

}
