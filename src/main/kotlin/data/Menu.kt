package data

class Menu private constructor(val header: String, val actions: List<MenuAction>) {

    companion object {
        class Builder(private val description: String) {
            private val actions: MutableList<MenuAction> = mutableListOf()
            fun addAction(actionDescription: String, actionHandler: () -> Unit): Builder {
                actions.add(MenuAction(actionDescription, actionHandler))
                return this
            }

            fun <T : NamedItem> addNamedItemsActions(namedItems: List<T>, action: (NamedItem) -> Unit) {
                namedItems.forEach { addAction(it.name) { action.invoke(it) } }
            }

            fun build(): Menu {
                return Menu(description, actions)
            }
        }
    }
}