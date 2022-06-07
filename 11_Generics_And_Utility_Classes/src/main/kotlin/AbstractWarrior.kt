import kotlin.random.Random

abstract class AbstractWarrior : Warrior {
    protected val name = getCodeName()

    abstract val maxHealth : Int

    abstract var health : Int

    abstract val accuracy : Int

    abstract val weapon : AbstractWeapon

    abstract val type : String

    override val isKilled : Boolean
        get() = health <= 0

    override val evasion : Int
        get() = Random.nextInt(0, 100)


    override fun attack(warrior : Warrior) {
        var damage = 0
        warrior as AbstractWarrior
        try {
            println("$type атакует ${warrior.type} ")
            weapon.getAmmoForFire().forEach {
                if (accuracy > warrior.evasion)
                    damage += it.getDamage()
                else println("${warrior.type} увернулся от $type")
            }
            warrior.getDamaged(damage)
            println("$name нанес урон $damage  ${warrior.type}")
        }catch (t : Throwable){
            println(t.message)
            weapon .recharge()
            println("$type перезарядил оружие")
        }


       /* if (weapon.isEmpty) {
            weapon.recharge()
            println("$type перезарядил оружие")
        } else {
            warrior as AbstractWarrior
            println("$type атакует ${warrior.type} ")
            weapon.getAmmoForFire().forEach {
                if (accuracy > warrior.evasion)
                    damage += it.getDamage()
                else println("${warrior.type} увернулся от $type")
            }
            warrior.getDamaged(damage)
            println("$name нанес урон $damage  ${warrior.type}")
        }*/
    }

    override fun getDamaged(damage : Int) {
        health -= damage
    }

    private fun getCodeName() : String{
        val a = arrayOf("Жирный ", "Усталый ", "Хитрый ", "Боевой ", "Скрытый ", "Большой ")
        val b = arrayOf("Пикачу", "Тапок", "Сектант", "Маг", "Бородач", "Павук")
        return "'"+a[Random.nextInt(0, a.size)] + b[Random.nextInt(0, b.size)]+"'"
    }


}