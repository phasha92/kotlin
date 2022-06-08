class TV(private val brandArg: String, private val modelArg: String, private val diagonalArg: Double) {

    // состояние работы
    private var power: Boolean

    // список каналов
    private val chanelList: Map<Int, String>

    // текущий канал
    private var chanelActive: Pair<Int, String>

    // громкость
    private var volume: Int

    // альтернативный конструктор
    constructor(descriptor: Pair<String, String>, diagonal: Double): this(
        brandArg = descriptor.first,
        modelArg = descriptor.second,
        diagonalArg = diagonal
    )

    companion object {
        // максимальная громкость
        private const val MAX_VOLUME = 100
        // минимальная громкость
        private const val MIN_VOLUME = 0
        // функция создания экземпляра
        fun create(name: String, model: String, diagonal: Double): TV = TV(name, model, diagonal)
    }

    init {
        println("экземпляр класса - $brandArg $modelArg  создан!")
        // настройка телевизора
        power = false
        chanelList = Chanels.getRandomChanels().toMap()
        chanelActive = chanelList.entries.first().toPair()
        volume = 50
    }
    // функции:

    // функция вкл/выкл // хотя можно было и через геттер, наверное)
    fun powerOnOrOff() {
        power = !power
        if (power) println("Телевизор включен.")
        else println("Телевизор выключен.")
    }

    // функция громкость +
    fun volumeUp(volume: Int) {
        if (power)
            if (this.volume + volume <= MAX_VOLUME) {
                this.volume += volume
                println("Громкость увеличена на : $volume текущая громкость = ${this.volume}")
            } else {
                this.volume = MAX_VOLUME
                println("Достигнута максимальная громкость: ${this.volume}")
            }
        else println("попытка увеличить громкость при выключенном телевизоре...")
    }

    // функция громкость -
    fun volumeDawn(volume: Int) {
        if (power)
            if (this.volume - volume >= MIN_VOLUME) {
                this.volume -= volume
                println("Громкость уменьшена на: $volume текущая громкость = ${this.volume}")
            } else {
                this.volume = MIN_VOLUME
                println("Достигнуто минимальная громкость: ${this.volume}")
            }
        else println("попытка уменьшить громкость при выключенном телевизоре...")
    }

    // функция переключения канала на конкретный
    fun chanelSwitch(chanel: Int) {
        if (power) {
            if (chanelList.containsKey(chanel)) {
                chanelActive = chanelList.entries.elementAt(chanel).toPair()
                println("Вы переключили на канал № ${chanelActive.first} - ${chanelActive.second}")
            } else {
                println("Канал №$chanel не найден!")
                println("Выбран предыдущий канал по умолчанию: № ${chanelActive.first} - ${chanelActive.second}")
            }
        } else { // если выключен, включаем и снова вызываем эту функцию
            powerOnOrOff()
            chanelSwitch(chanel)
        }
    }

    // функция отображения списка каналов
    fun printChanels() {
        if (power) {
            println("Список каналов:")
            for (entry in chanelList.entries)
                println(" №${entry.key} - ${entry.value}")
        } else println("Просмотр списка каналов при выключенном телевизоре не доступен!")
    }

    // функция переключения канала +
    fun chanelUp() {
        if (power) {
            chanelActive = if (chanelActive == chanelList.entries.last().toPair()) {
                chanelList.entries.first().toPair()
            } else {
                chanelList.entries.elementAt(chanelActive.first + 1).toPair()
            }
            println("""+Вы переключили на следующий канал:
№ ${chanelActive.first} - ${chanelActive.second}""".trimMargin())
        } else {
            powerOnOrOff()
            println("Вы смотрите канал  № ${chanelActive.first} - ${chanelActive.second}")
        }
    }

    // функция переключения канала -
    fun chanelDawn() {
        if (power) {
            chanelActive = if (chanelActive == chanelList.entries.first().toPair()) {
                chanelList.entries.last().toPair()
            } else {
                chanelList.entries.elementAt(chanelActive.first - 1).toPair()
            }
            println("""-Вы переключили на предыдущий канал:
№ ${chanelActive.first} - ${chanelActive.second}""".trimMargin())
        } else {
            powerOnOrOff()
            println("Вы смотрите канал  № ${chanelActive.first} - ${chanelActive.second}")
        }
    }

    override fun toString(): String {
        return "\n$brandArg $modelArg с диагональю: $diagonalArg. "
    }
}