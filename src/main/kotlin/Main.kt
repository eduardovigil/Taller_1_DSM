import java.io.File

fun main() {
    // Solicitar el nombre y el salario base del empleado
    println("Ingrese el nombre del empleado:")
    val nombre = readLine()

    println("Ingrese el salario base del empleado:")
    val salarioBaseStr = readLine()

    // Convertir el salario base a un valor numérico
    val salarioBase = salarioBaseStr?.toDoubleOrNull()

    if (nombre != null && salarioBase != null) {
        // Calcular el sueldo neto
        val salarioNeto = calcularSalarioNeto(salarioBase)

        // Imprimir el salario neto en la consola
        println("Salario neto del empleado.")
        println("Nombre del empleado: $nombre")
        println("Salario base: $salarioBase")
        println("Salario neto: $salarioNeto")

        // Escribir el resultado en un archivo de texto
        escribirResultadoEnArchivo(nombre, salarioBase, salarioNeto)
    } else {
        println("Entrada no válida. Asegúrese de ingresar un nombre y un salario válido.")
    }
}

fun calcularSalarioNeto(salarioBase: Double): Double {
    // Descuentos a descontar del sueldo base
    val descuentoISS = salarioBase * 0.03
    val descuentoAFP = salarioBase * 0.04
    val descuentoRenta = salarioBase * 0.05
    val descuento = descuentoAFP + descuentoISS + descuentoRenta
    return salarioBase - descuento
}

fun escribirResultadoEnArchivo(nombre: String, salarioBase: Double, salarioNeto: Double) {
    val archivoResultado = File("Salario.txt")
    archivoResultado.writeText("Nombre del empleado: $nombre\n")
    archivoResultado.appendText("Salario base: $salarioBase\n")
    archivoResultado.appendText("Salario neto: $salarioNeto\n")

}