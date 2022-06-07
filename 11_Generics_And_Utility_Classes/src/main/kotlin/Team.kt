import kotlin.random.Random

class Team(val name : String) {
    val team : List<Warrior>

    private fun callToService() : List<Warrior> {
        val list = mutableListOf<Warrior>()
        for (i in 1..10) {
            when (Random.nextInt(1, 101)) {
                in 1..10 -> list.add(Sniper())
                in 11..30 -> list.add(Commander())
                in 31..50 -> list.add(Soldier())
                in 51..70 -> list.add(Medic())
                in 71..100 -> list.add(General())
            }
        }
        return list
    }

    init {
        println("Команда '$name' создана")
        team = callToService()

    }
}