fun main() {
    var op: Int;
    do {
        println("=====================> Taller 1 DSM <=====================")
        println("1.  Promedio (ejercicio 1).")
        println("2.  Salario (ejercicio 2).")
        println("3.  Calculadora (ejercicio 3).")
        println("4.  Salir.")
        op = readLine()!!.toInt()

        when (op) {
            1 -> promedio()
            2 -> salario()
            3 -> calculadora()
            4 -> println("Saliendo del programa...")
            else -> println("Opción no válida.")
        }
    } while (op != 4)

}