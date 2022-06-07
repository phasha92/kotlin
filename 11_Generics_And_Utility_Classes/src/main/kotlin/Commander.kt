class Commander : AbstractWarrior() {
    override val type = "Commander"

    override val maxHealth = 150

    override var health : Int = maxHealth
        set(value) {
            field = if (value > 0)
                if (value > field && value > maxHealth) maxHealth
                else value
            else 0
        }

    override val accuracy = 60

    override val weapon = Weapons.createShotGun()

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