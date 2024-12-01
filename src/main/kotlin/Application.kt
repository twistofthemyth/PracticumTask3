import data.Archive
import data.Note
import screens.ArchiveScreen
import screens.MainScreen
import screens.NoteScreen
import java.util.*
import kotlin.system.exitProcess

class Application {
    companion object {
        private val archives: MutableList<Archive> = mutableListOf()
        private val scanner = Scanner(System.`in`)
        fun run() {
            runMainScreen()
        }

        internal fun runMainScreen() {
            while (true) MainScreen(archives).render()
        }

        internal fun runArchiveScreen(archive: Archive) {
            while (true) ArchiveScreen(archive).render()
        }

        internal fun runNoteScreen(archive: Archive, note: Note) {
            while (true) NoteScreen(archive, note).render()
        }

        internal fun readUserInput(): String {
            return scanner.nextLine()
        }

        internal fun exit() {
            scanner.close()
            println("  _,-=._              /|_/|\n" +
                    "  `-.}   `=._,.-=-._.,  @ @._,\n" +
                    "     `._ _,-.   )      _,.-'\n" +
                    "        `    G.m-\"^m`m'")
            exitProcess(0)
        }
    }
}

fun main() {
    Application.run()
}