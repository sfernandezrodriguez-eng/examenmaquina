package org.danielcastelao.dam

// nivel en el que se encuentra el ascensor
var nivel_actual: Int = 0
// estado actual del ascensor
var estado_acual: Estados = Estados.Idle
var nivel_0: Boolean=false
var nivel_1: Boolean=false

/**
 * Gestiona el cambio de estados
 */
fun gestor(): Int {
    when (estado_acual) {
        is Estados.Idle -> {
            nivel_actual = 0
            while (nivel_0 != true or nivel_1 != true){
                nivel_actual = 0
                estado_actual = Estados.Idle
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
