import java.io.File

object Searcher {
    private var a = ""
    fun fileSearch(root: File, name: String): String {
        if (root.isDirectory) root.listFiles()?.let {
            it.forEach { item ->
                if (item.isDirectory) {
                    fileSearch(item, name)
                } else {
                    if (item.name.endsWith("$name.txt")) {
                        a = item.absolutePath
                        return@let
                    }
                }
            }
        }
        return a
    }
}