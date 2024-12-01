package data

data class Note(override val name: String, var content: String) : NamedItem(name)