package acuario

// Clase abstracta
abstract class Pez {
    abstract val color: String
}

//  Interfaz
interface AccionPez {
    fun comer()
}

// Clases concretas que heredan de Pez e implementan AccionPez
class Tiburon : Pez(), AccionPez {
    override val color = "gris"

    override fun comer() {
        println("El tiburón caza y come peces")
    }
}

class PezPayaso : Pez(), AccionPez {
    override val color = "dorado"

    override fun comer() {
        println("El pez payaso come algas")
    }
}
