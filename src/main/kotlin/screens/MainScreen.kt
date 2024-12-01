package screens

import Application
import data.Archive
import data.Menu

class MainScreen(private val archives: MutableList<Archive>) : NumericMenuScreen("Список архивов") {
    override fun configureMenuActions(menuBuilder: Menu.Companion.Builder) {
        menuBuilder
            .addAction("Создать архив") { invokeArchiveEditor() }
            .addNamedItemsActions(archives) { Application.runArchiveScreen(it as Archive) }
    }

    override fun invokeBackOption() {
        Application.exit()
    }

    private fun invokeArchiveEditor() {
        val archiveName = TextEditorScreen("название архива").render()
        archives.add(Archive(archiveName))
    }
}