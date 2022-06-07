class Medic : AbstractWarrior(), Medical {
    override val type = "Medic"

    override val maxHealth = 100

    override var health : Int = maxHealth
        set(value) {
            field = if (value > 0)
                if (value > field && value > maxHealth) maxHealth
                else value
            else 0
        }

    override val accuracy = 50

    override val weapon = Weapons.createPistol()

    init {
        println("""
            |Боец $type призван!
            |Характеристики: 
            |кодовое имя: $name
            |здоровье: $health
            |оружие: ${weapon.fireType}
            |меткость: $accuracy
       
        """.trimMargin())
    }

    override fun toString() : String {
        return """$type $name $health"""
    }

    override fun teatment(warrior : Warrior) {
        warrior as AbstractWarrior
        if (warrior.health > 0 && warrior.health < warrior.maxHealth) {
            warrior.health += 50
            println("$type вылечил ${warrior.type}a до ${warrior.health}")
        } else
            if (warrior.health == warrior.maxHealth) println("${warrior.type} полностью здоров")
            else
                println("$type не может воскресить ${warrior.type} (((")
    }
}