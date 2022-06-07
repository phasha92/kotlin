class Wheel {
    private var pressure = 0.0

    private fun isCorrectPush(d : Double) : Boolean {
        if (d < 0 || d > 10)
            throw IncorrectPressure()
        else
            if (d < 1.6)
                throw TooLowPressure()
            else
                if (d > 2.5)
                    throw TooHighPressure()
        return true
    }

    fun push(d : Double) {

        try {
            if (isCorrectPush(d)) pressure = d
            println("Установлено $d атмосфер")
        } catch (t : Throwable) {
            println("$d ${t.message}")
        }
    }

}

class TooLowPressure : Throwable(message = "Давление ниже допустимого")
class TooHighPressure : Throwable(message = "Давление Выше допустимого")
class IncorrectPressure : Throwable(message = "Недопустимое значение")