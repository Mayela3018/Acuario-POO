package acuario

// Clase Persona debe ser 'open' para poder heredarla
open class Persona(val nombre: String, var edad: Int) {
    fun presentarse() {
        println("Hola, soy $nombre y tengo $edad años.")
    }
}

// Clase Estudiante que hereda de Persona
class Estudiante(nombre: String, edad: Int, val curso: String) : Persona(nombre, edad) {
    fun estudiar() {
        println("$nombre está estudiando $curso.")
    }
}


fun main() {
    val persona1 = Persona("Ana", 25)
    persona1.presentarse()

    val persona2 = Persona("Luis", 30)
    persona2.presentarse()

    val estudiante = Estudiante("Mayo", 20, "Kotlin")
    estudiante.presentarse()
    estudiante.estudiar()
}
