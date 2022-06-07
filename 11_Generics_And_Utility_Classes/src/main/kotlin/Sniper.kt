class Sniper : AbstractWarrior() {
    override val type = "Sniper"

    override val maxHealth = 100

    override var health : Int = maxHealth
        set(value) {
            field = if (value > 0)
                if (value > field && value > maxHealth) maxHealth
                else value
            else 0
        }


    override val accuracy = 90

    override val weapon = Weapons.createRifle()

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
}