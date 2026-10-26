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
    when (val state=estado_actual) {
        is Estados.Idle -> state.onEnter()

        is Estados.MovingUP -> {
            nivel_actual = 2
            println("Esta subiendo...")

            if (nivel_0) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1 && nivel_0) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            }
            else{
                //Si nada falla
                estado_actual = Estados.Idle
            }
            return nivel_actual
        }
        is Estados.MovingDOWN -> {
            nivel_actual = 2
            println("Esta bajando...")

            if (nivel_0) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1 && nivel_0) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            }
            else{
                //Si nada falla
                estado_actual = Estados.Idle
            }

            return nivel_actual
        }
        is Estados.Error -> {
            nivel_actual = -1
            println("Ha habido un problema, se esta solucionando")
            estado_actual = Estados.Idle
            return nivel_actual
        }
    }
}
