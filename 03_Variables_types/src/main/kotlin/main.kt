fun main() {
    //Имя
    val firstName: String?

    //Фамилия
    val lastName: String?

    //Рост
    var height: Double?

    //Вес
    val weight: Float?

    //данные
    firstName = "Masha"
    lastName = "Ivanova"
    height = 145.0
    weight = 45f

    /*
   *Условие проверки указывающее:
   *"являетесь ли Вы ребенком"
   */

    val isChild = { _height: Double, _weight: Float -> _height < 150.0 || _weight < 40f }

    //Информация о человеке
    var info = """$firstName $lastName
Height: ${height}sm 
Weight: ${weight}kg
Is child: ${isChild(height, weight)}"""

    //Вывод 1
    println("Conclusion #1:\n$info\n")

    //Меняем рост
    height = 155.0

    //Обновляем информацию
    info = """$firstName $lastName
Height: ${height}sm 
Weight: ${weight}kg
Is child: ${isChild(height, weight)}"""

    //Вывод 2
    println("Conclusion #2:\n$info\n")
}