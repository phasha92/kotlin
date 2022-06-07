@file:Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")

import kotlin.Boolean as KotlinBoolean

fun main() {
    //Имя
    val firstName : String?

    //Фамилия
    val lastName : String?

    //Рост
    var height : Double?

    //Вес
    val weight : Float?

    //данные
    firstName = "Masha"
    lastName = "Ivanova"
    height = 145.0
    weight = 45f

    /*
   *Условие проверки указывающее:
   *"являетесь ли Вы ребенком"
   */

    var isChild : KotlinBoolean


    //Информация о человеке
    var info = """$firstName $lastName
Height: ${height}sm 
Weight: ${weight}kg
Is child: ${(height < 150.0 || weight < 40f).also { isChild = it }}"""

    //Вывод 1
    println("Conclusion #1:\n$info\n")

    //Меняем рост
    height = 155.0

    //Обновляем информацию
    info = """$firstName $lastName
Height: ${height}sm 
Weight: ${weight}kg
Is child: ${(height < 150.0 || weight < 40f).also { isChild = it }}"""

    //Вывод 2
    println("Conclusion #2:\n$info\n")
}