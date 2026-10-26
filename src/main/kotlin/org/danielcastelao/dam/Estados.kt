package org.danielcastelao.dam

sealed class Estados {
    object Idle : Estados()
    data class MovingUP(val estado_actual: Int) : Estados()
    data class MovingDOWN(val estado_actual: Int) : Estados()
    data class Error(val estado_actual: Int) : Estados()
}