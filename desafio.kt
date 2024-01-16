enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

open class Usuario(open val nome: String, open val email: String) {
    override fun toString(): String {
        return "Usuario(nome='$nome', email='$email')"
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel =Nivel.BASICO)

data class Formacao(val formacaoNome: String, private val conteudos: List<ConteudoEducacional>) : Usuario("", "") {

    private val inscritos = mutableListOf<Usuario>()

    fun getConteudos(): List<ConteudoEducacional> {
        return conteudos
    }

    fun getInscritos(): List<Usuario> {
        return inscritos
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        // Implementar lógica adicional, se necessário
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", nivel = Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120, nivel = Nivel.INTERMEDIARIO)

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2))

    val usuario1 = Usuario("João Silva", "joao.silva@email.com")
    formacaoKotlin.matricular(usuario1)

    println("Conteúdos da formação: ${formacaoKotlin.getConteudos()}")
    println("Inscritos na formação: ${formacaoKotlin.getInscritos()}")
}
