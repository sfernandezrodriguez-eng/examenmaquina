package org.danielcastelao.dam

// nivel en el que se encuentra el ascensor
var nivel_actual: Int = 0
// estado actual del ascensor
var estado_actual: Estados = Estados.Idle
var nivel_0: Boolean=false
var nivel_1: Boolean=false

/**
 * Gestiona el cambio de estados
 */
fun gestor(): Int {
    when (estado_actual) {
        is Estados.Idle -> {
            println("Bienvenido al ascnesor")
            nivel_actual = 0
            if (nivel_0) {
                nivel_actual = -1
                estado_actual = Estados.Error

            }
            else if (nivel_1){
                nivel_actual = 2
                estado_actual = Estados.MovingUP(nivel_actual)

            }
            else if (nivel_1 && nivel_0){
                nivel_actual = -1
                estado_actual = Estados.Error

            }

            return nivel_actual
        }
        is Estados.MovingUP -> {
            nivel_actual = 2
            return nivel_actual
        }
        is Estados.MovingDOWN -> {
            nivel_actual = 2
            return nivel_actual
        }
        is Estados.Error -> {
            nivel_actual = -1
            return nivel_actual
        }
    }
}
