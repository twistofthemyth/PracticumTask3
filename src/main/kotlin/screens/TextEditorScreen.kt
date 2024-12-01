package screens

import Application

class TextEditorScreen(val description: String) : Screen<String> {

    override fun render(): String {
        while (true) {
            println("Введите $description")
            val input = Application.readUserInput()
            if (input.isNotEmpty()) {
                return input
            } else {
                println("Ошибка! ${description.replaceFirstChar { it.uppercaseChar() }} не может быть пустой строкой.")
            }
        }
    }
}