class General : AbstractWarrior() {
    override val type = "General"

    override val maxHealth = 200

    override var health : Int = maxHealth
        set(value) {
            field = if (value > 0)
                if (value > field && value > maxHealth) maxHealth
                else value
            else 0
        }

    override val accuracy = 70

    override val weapon = Weapons.createAutomate()

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