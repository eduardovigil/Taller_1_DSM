import java.io.File
import java.io.FileWriter

fun calculadora() {
    println("Calculadora")

    print("Ingrese el primer valor: ")
    val num1 = readLine()?.toDoubleOrNull() ?: run {
        println("Ingrese un número válido.")
        return
    }

    print("Ingrese el segundo valor: ")
    val num2 = readLine()?.toDoubleOrNull() ?: run {
        println("Ingrese un número válido")
        return
    }

    print("Ingrese el operador (+, -, *, /): ")
    val operador = readLine()

    var resultado: Double = 0.0

    when (operador) {
        "+" -> resultado = num1 + num2
        "-" -> resultado = num1 - num2
        "*" -> resultado = num1 * num2
        "/" -> {
            if (num2 != 0.0) {
                resultado = num1 / num2
            } else {
                println("Operación inválida. No se puede dividir por cero.")
                return
            }
        }
        else -> {
            println("Operador $operador no válido.")
            return
        }
    }
    println("Resultado: $resultado")

    val resTxt = "Operación: $num1 $operador $num2 = $resultado \n"
    val archivo = File("resultados.txt")

    try {
        if(!archivo.exists())
            archivo.createNewFile()
        FileWriter(archivo, true).use { writer ->
            writer.write(resTxt)
        }
        println("Resultado guardado")
    } catch (err: Exception) {
        println("Error al guardar el resultado")
        println(err)
    }
}
