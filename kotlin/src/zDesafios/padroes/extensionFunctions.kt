fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")

    println("${slugTitulo}_$slugAutor")
}

fun String.generateSlug(): String {
    // Substituir espaços por traços
    return this.replace(" ", "-").replace(Regex("[^A-Za-z0-9-]"), "").lowercase()
}
 