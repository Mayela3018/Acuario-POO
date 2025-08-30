package acuario

// Demo sencillo que muestra y usa todas las partes del laboratorio
fun demoApp() {
    println("=== Demo Acuario - Inicio ===\n")

    // 1) Crear un acuario normal (constructor primario)
    println("-- 1) Acuario creado con constructor primario --")
    val acuario = Acuario(largo = 60, ancho = 30, alto = 50)
    acuario.imprimirTamano()
    println()

    // 2) Lista de peces (abstracta + interfaz)
    println("-- 2) Crear peces y mostrar colores --")
    val peces: MutableList<Pez> = mutableListOf(Tiburon(), PezPayaso(), PezPayaso())
    println("Colores de peces en el tanque: " + peces.joinToString { it.color })
    println()

    // 3) Usar la interfaz AccionPez para alimentar (polimorfismo)
    println("-- 3) Alimentando peces (llamando a comer()) --")
    for (p in peces) {
        // todos los peces implementan AccionPez, así que llamamos a comer()
        if (p is AccionPez) p.comer()
    }
    println()

    // 4) Mostrar el setter de volumen: cambiar litros y ver que recalcula alto
    println("-- 4) Ajustar volumen con el setter (por ejemplo 40 L) --")
    println("Antes:")
    acuario.imprimirTamano()
    acuario.volumen = 40   // usa el setter para recalcular alto
    println("Después de asignar volumen = 40 L:")
    acuario.imprimirTamano()
    println()

    // 5) Crear un TanqueTorre (herencia) y mostrar cálculo cilíndrico
    println("-- 5) TanqueTorre (cilíndrico) --")
    val torre = TanqueTorre(diametro = 30, alto = 60)
    torre.imprimirTamano()
    println()

    // 6) Crear un acuario usando constructor secundario (por número de peces)
    println("-- 6) Crear acuario según número de peces (p.ej. 15 peces) --")
    val porPeces = Acuario(numeroDePeces = 15)
    porPeces.imprimirTamano()
    println()

    println("=== Demo Acuario - Fin ===")
}
