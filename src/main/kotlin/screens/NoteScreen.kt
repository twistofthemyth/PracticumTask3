package screens

import Application
import data.Archive
import data.Note

open class NoteScreen(private val archive: Archive, private val note: Note) : NumericMenuScreen("Действия с заметкой ${note.name}") {
    override fun render() {
        println("Просмотр заметки ${note.name}")
        println(note.content)
        super.render()
    }

    override fun invokeBackOption() {
        Application.runArchiveScreen(archive)
    }
}