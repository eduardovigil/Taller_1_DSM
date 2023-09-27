import java.io.File

fun main() {
    println("Calculadora de Promedio de Calificaciones")

    // Solicitar el nombre del estudiante
    println("Ingrese el nombre del estudiante:")
    val nombres = readLine()

    val numCalificaciones = 5
    var calificaciones = mutableListOf<Double>()

    // Solicitar las 5 calificaciones
    for (i in 1..numCalificaciones) {
        var calificacion: Double?
        do {
            println("Ingrese la calificación #$i (entre 0 y 10):")
            val calificacionStr = readLine()
            calificacion = calificacionStr?.toDoubleOrNull()
        } while (calificacion == null || calificacion < 0.0 || calificacion > 10.0)

        calificaciones.add(calificacion)

    }

    // Calcular el promedio
    val promedio = calcularPromedio(calificaciones)

    // Establecer un valor de aprobación
    val valorAprobacion = 6.0

    // Determinar si aprobó o reprobó
    val estado = if (promedio >= valorAprobacion) "Aprobado" else "Reprobado"

    // Imprimir el promedio y el estado en la consola
    println("Resultado de notas")
    println("Nombre del estudiante: $nombres")
    println("El promedio de las calificaciones es: $promedio")
    println("Estado del estudiante en la materia: $estado")

    // Escribir el resultado en un archivo de texto
    if (nombres != null) {
        escribirResultadoEnArchivo(nombres,promedio, estado)
    }
}

fun calcularPromedio(calificaciones: List<Double>): Double {
    val totalCalificaciones = calificaciones.sum()
    return totalCalificaciones / calificaciones.size
}

fun escribirResultadoEnArchivo(nombres: String, promedio: Double, estado: String) {
    val archivoResultado = File("promedio_calificaciones.txt")
    archivoResultado.writeText("Nombre del estudiante: $nombres\n")
    archivoResultado.appendText("Promedio: $promedio\n")
    archivoResultado.appendText("Estado del estudiante en la materia: $estado\n")

}
