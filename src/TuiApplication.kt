class TuiApplication {

    val university = University()

    fun addStudent() {
        println("Enter name:")
        val name = readln()
        println("Enter course:")
        val course = readln()
        println("Enter id:")
        val id = readln()
        university.addStudent(Student(id, name, course))
    }

    fun searchForStudentById() {
        println("Enter ID:")
        val id = readln()
        val student = university.findStudentById(id)

        if (student == null) {
            println("No student found")
        } else {
            println(student)
        }
    }

    fun searchForStudentsByCourse() {
        println("Enter course:")
        val course = readln()
        val students = university.findStudentsByCourse(course)

        if (students.isEmpty()) {
            println("No matching students")
        } else {
            for (s in students) {
                println(s)
            }
        }
    }

    fun run() {

        // Three menu handlers using lambdas and SAM conversions
        val menuHandlers = arrayOf<MenuItemHandler>(
            MenuItemHandler { addStudent() },
            MenuItemHandler { searchForStudentById() },
            MenuItemHandler { searchForStudentsByCourse() }
        )

        var running = true

        while (running) {

            println("0: Add Student")
            println("1: Search for Student By ID")
            println("2: Search for Students By course")
            println("3: Quit")

            val input = readln().toInt()

            when (input) {
                in 0..2 -> menuHandlers[input].onMenuItemSelected(input)
                3 -> running = false
                else -> println("Error: invalid option")
            }
        }
    }
}



