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

        is Estados.MovingUP -> state.onEnter()

        is Estados.MovingDOWN -> state.onEnter()
        is Estados.Error -> state.onEnter()
    }
    return nivel_actual
}
