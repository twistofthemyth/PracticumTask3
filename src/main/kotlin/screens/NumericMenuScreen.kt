package screens

import data.Menu

abstract class NumericMenuScreen(private val header: String) : Screen<Unit> {

    override fun render() {
        val menuBuilder = Menu.Companion.Builder(header)
        configureMenuActions(menuBuilder)
        menuBuilder.addAction("Выход") { invokeBackOption() }
        menuBuilder.build().render()
    }

    protected open fun configureMenuActions(menuBuilder: Menu.Companion.Builder) {
        //do nothing by default
    }

    protected abstract fun invokeBackOption();
}