package com.example.dataclasshomework.dataclass

fun main() {

    val languageList = listOf(
        Language("Kotlin"),
        Language("Java"),
    )

    val teacherList = listOf(
        Teacher("Николай", 37, 12, languageList),
        Teacher("Кирилл", 12, 12, languageList),
        Teacher("Анастасия", 7, 5, languageList),
        Teacher("Евгений", 2, 1, languageList)
    )

    val experiencedTeacher = getExperiencedTeacher(experience = 5, teacherList = teacherList)

    if (experiencedTeacher.isNotEmpty()) {
        println(experiencedTeacher)
    } else {
        println("Учитель с таким опытом не найден")
    }
}

private fun getExperiencedTeacher(experience: Int, teacherList: List<Teacher>): List<String> {
    val experiencedTeachers = teacherList.filter { it.progExperience > experience }.map { it.name }
    return experiencedTeachers
}
