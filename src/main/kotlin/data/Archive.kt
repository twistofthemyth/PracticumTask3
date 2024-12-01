package data

data class Archive(override val name: String, val notes: MutableList<Note> = mutableListOf()) : NamedItem(name)