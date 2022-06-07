import kotlin.random.Random

object Chanels {
    private val chanel = mapOf(
        0 to "Первый",
        1 to "Россия1",
        2 to "НТВ",
        3 to "Рен-ТВ",
        4 to "ТНТ",
        5 to "Пятница",
        6 to "2х2",
        7 to "Муз-ТВ",
        8 to "СТС",
        9 to "Домашний"
    )



    //перемешанные каналы
    fun getRandomChanels() : Map<Int, String> {
        val key = this.chanel.keys.toList()
        val value = this.chanel.values.toList().shuffled()
        val map = mutableMapOf<Int, String>()
        val count = Random.nextInt(2,10)
        for (i : Int in 0 until count) {
            val pair : Pair<Int,String> = Pair(key[i], value[i])
            map[pair.first] = pair.second
        }
        return map
    }
}