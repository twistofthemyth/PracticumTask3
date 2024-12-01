package data

data class Archive(override val name: String) : NamedItem(name) {
    private val notes: MutableList<Note> = mutableListOf()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getNotes(): List<Note> {
        return notes
    }
}