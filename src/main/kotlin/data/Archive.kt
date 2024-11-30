package data

data class Archive(val name: String) {
    private val notes: MutableList<Note> = mutableListOf()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getNotes(): List<Note> {
        return notes
    }
}