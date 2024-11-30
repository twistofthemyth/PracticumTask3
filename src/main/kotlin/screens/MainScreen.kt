package screens

import Application
import data.Archive
import data.Menu

class MainScreen(private val archives: MutableList<Archive>) : NumericMenuScreen("Список архивов") {
    override fun configureMenuActions(menuBuilder: Menu.Companion.Builder) {
        menuBuilder.addAction("Создать архив") { invokeArchiveEditor() }
        archives.forEach { menuBuilder.addAction(it.name) { Application.runArchiveScreen(it) } }
    }

    override fun invokeBackOption() {
        Application.exit()
    }

    private fun invokeArchiveEditor() {
        val archiveName = TextEditorScreen("название архива").render()
        createArchive(archiveName)
    }

    private fun createArchive(name: String): Archive {
        val archive = Archive(name)
        archives.add(archive)
        return archive
    }

    private fun getArchive(name: String): Archive {
        return archives.find { name == it.name } ?: createArchive(name)
    }
}