class TV(val brandArg : String, val modelArg : String, val diagonalArg : Double) {

    //состояние работы
    private var power : Boolean

    //список каналов
    private var chanelList : Map<Int, String>

    //текущий канал
    private var chanelActive : Pair<Int, String>

    //громкость
    private var volume : Int

    //конструктор
    constructor(descriptor : Pair<String, String>, diagonal : Double) : this(
        brandArg = descriptor.first,
        modelArg = descriptor.second,
        diagonalArg = diagonal
    )

    companion object {

        //максимальная громкость
        private const val maxVolume = 100

        //минимальная громкость
        private const val minVolume = 0

    }

    init {
        println("экземпляр класса - $brandArg $modelArg  создан!")
        //настройка телевизора
        power = false

        chanelList = Chanels.getRandomChanels().toMap()

        chanelActive = chanelList.entries.first().toPair()

        volume = 50
    }
    //функции:

    //функция вкл/выкл
    fun powerOnOrOff() {
        power = !power
        if (power) println("Телевизор включен.")
        else println("Телевизор выключен.")
    }

    //функция громкость +
    fun volumeUp(volume : Int) {
        if (power)
            if (this.volume + volume <= maxVolume) {
                this.volume += volume
                println("Громкость увеличена на : $volume текущая громкость = ${this.volume}")
            } else {
                this.volume = maxVolume
                println("Достигнута максимальная громкость: ${this.volume}")
            }
        else println("попытка увеличить громкость при выключенном телевизоре...")
    }

    //функция громкость -
    fun volumeDawn(volume : Int) {
        if (power)
            if (this.volume - volume >= minVolume) {
                this.volume -= volume
                println("Громкость уменьшена на: $volume текущая громкость = ${this.volume}")
            } else {
                this.volume = minVolume
                println("Достигнуто минимальная громкость: ${this.volume}")
            }
        else println("попытка уменьшить громкость при выключенном телевизоре...")
    }

    //функция переключения канала на конкретный
    fun chanelSwitch(chanel : Int) {
        if (power) {
            if (chanelList.containsKey(chanel)) {
                chanelActive = chanelList.entries.elementAt(chanel).toPair()
                println("Вы переключили на канал № ${chanelActive.first} - ${chanelActive.second}")
            } else {
                println("Канал №$chanel не найден!")
                println("Выбран предыдущий канал по умолчанию: № ${chanelActive.first} - ${chanelActive.second}")
            }
        } else { //если выключен, включаеми снова вызываем эту функцию
            powerOnOrOff()
            chanelSwitch(chanel)
        }
    }

    //функция отображения списка каналов
    fun printChanels() {
        if (power) {
            println("Список каналов:")
            for (entry in chanelList.entries)
                println(" №${entry.key} - ${entry.value}")
        } else println("Просмотр списка каналов при выключенном телевизоре не доступен!")
    }

    //функция переключения канала +
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

    //функция переключения канала -
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
}