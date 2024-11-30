package screens

import Application
import data.Archive
import data.Menu
import data.Note

class ArchiveScreen(private val archive: Archive) : NumericMenuScreen("Заметки архива ${archive.name}") {
    override fun configureMenuActions(menuBuilder: Menu.Companion.Builder) {
        menuBuilder.addAction("Создать заметку") { invokeNoteCreation() }
        archive.getNotes()
            .forEach { menuBuilder.addAction(it.name) { Application.runNoteScreen(archive, it) } }
    }

    override fun invokeBackOption() {
        Application.runMainScreen()
    }

    private fun invokeNoteCreation() {
        val noteName = TextEditorScreen("имя заметки").render()
        val noteContent = TextEditorScreen("содержание заметки").render()
        archive.addNote(Note(noteName, noteContent))
    }
}