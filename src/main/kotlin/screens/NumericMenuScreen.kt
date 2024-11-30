package screens

import Application
import data.Menu

abstract class NumericMenuScreen(private val header: String) : Screen<Unit> {

    private enum class InputStatus {
        OK,
        WRONG_FORMAT,
        NO_HANDLERS
    }

    override fun render() {
        val menuBuilder = Menu.Companion.Builder(header)
        configureMenuActions(menuBuilder)
        menuBuilder.addAction("Выход") { invokeBackOption() }
        renderMenu(menuBuilder.build())
    }

    private fun renderMenu(menu: Menu) {
        var terminate = false
        while (!terminate) {
            println(menu.header)
            menu.actions.forEachIndexed { index, action -> println("${index}. ${action.description}") }
            val input = Application.readUserInput()
            val status = handleInput(menu, input)
            when (status) {
                InputStatus.OK -> terminate = true
                InputStatus.WRONG_FORMAT -> println("Необходимо ввести цифру")
                InputStatus.NO_HANDLERS -> println("Такого элемента нет на экране")
            }
        }
    }

    private fun handleInput(menu: Menu, input: String): InputStatus {
        val optionIndex = input.toIntOrNull() ?: return InputStatus.WRONG_FORMAT
        if (menu.actions.size <= optionIndex) return InputStatus.NO_HANDLERS

        menu.actions[optionIndex].handler.invoke()
        return InputStatus.OK
    }

    protected open fun configureMenuActions(menuBuilder: Menu.Companion.Builder) {
        //do nothing by default
    }

    protected abstract fun invokeBackOption()
}