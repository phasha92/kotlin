class Employes(_name: String, _surName: String, _salary: Int) {
    val name: String
    val surName: String
    val salary: Int

    init {
        name = _name
        surName = _surName
        salary = _salary

        println("""сотрудник создан:
            |имя : $name
            |фамилия : $surName
            |зарплата : $salary
            |
        """.trimMargin())
    }
}