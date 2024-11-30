package data

import Application

class Menu private constructor(private val header: String, private val actions: List<MenuAction>) {

    private enum class InputStatus {
        OK,
        WRONG_FORMAT,
        NO_HANDLERS
    }

    fun render() {
        var terminate = false
        while (!terminate) {
            println(header)
            actions.forEachIndexed { index, action -> println("${index}. ${action.description}") }
            val input = Application.readUserInput()
            val status = handleInput(input)
            when (status) {
                InputStatus.OK -> terminate = true
                InputStatus.WRONG_FORMAT -> println("Необходимо ввести цифру")
                InputStatus.NO_HANDLERS -> println("Такого элемента нет на экране")
            }
        }
    }

    private fun handleInput(input: String): InputStatus {
        val optionIndex = input.toIntOrNull() ?: return InputStatus.WRONG_FORMAT
        if (actions.size <= optionIndex) return InputStatus.NO_HANDLERS

        actions[optionIndex].handler.invoke()
        return InputStatus.OK
    }

    companion object {
        class Builder(private val description: String) {
            private val actions: MutableList<MenuAction> = mutableListOf()
            fun addAction(actionDescription: String, actionHandler: () -> Unit): Builder {
                actions.add(MenuAction(actionDescription, actionHandler))
                return this
            }

            fun build(): Menu {
                return Menu(description, actions)
            }
        }
    }
}