enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val sobrenome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)
    
data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    
    // Criacao de usuarios
    val usuario1 = Usuario("Sofia", "almeida")
    val usuario2 = Usuario("Daniel", "silva")
    val usuario3 = Usuario("Luciana", "silva")
    
    
    // Criacao de conteudos
    val conteudo1 = ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 2, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Introdução Prática a Linguagem de Programação Kotlin", 2, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Conhecendo o Javascript", 2, Nivel.BASICO)
    val listaConteudoEducacionalKotlin = mutableListOf(conteudo1, conteudo2)
    val listaConteudoEducacionalJavascript = mutableListOf(conteudo3)
    
    // Criacao de formacoes
    val kotlin = Formacao("Kotlin Experience", Nivel.BASICO, listaConteudoEducacionalKotlin)
    val javascript = Formacao("Javascript Experience", Nivel.INTERMEDIARIO, listaConteudoEducacionalJavascript)
    
    // Matricula usuario na formacao kotlin
    kotlin.matricular(usuario1)
    kotlin.matricular(usuario2)
    
    // Matricula usuario na formacao javascript
    javascript.matricular(usuario3)
    
    
    // Impressão
    println("==Formacao ${kotlin.nome}==")
    println("Conteudos da Formacao:")
    kotlin.conteudos.forEach { println("- $it") }
    println()
    println("Usuarios inscritos na formacao ${kotlin.nome}:")
    kotlin.inscritos.forEach { println("- $it") }
    
    println()
    
    println("==Formacao ${javascript.nome}==")
    println("Conteudos da Formacao:")
    javascript.conteudos.forEach { println("- $it") }
    println()
    println("Usuarios inscritos na formacao ${kotlin.nome}:")
    javascript.inscritos.forEach { println("- $it") }
}