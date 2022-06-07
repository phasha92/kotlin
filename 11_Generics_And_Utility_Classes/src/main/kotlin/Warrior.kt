interface Warrior {
    val isKilled : Boolean
    val evasion : Int // уклонение
    fun attack(warrior : Warrior)
    fun getDamaged(damage : Int)
}