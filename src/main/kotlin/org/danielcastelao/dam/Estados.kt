package org.danielcastelao.dam

sealed class Estados {
    object Idle : Estados()
    data class MovingUP(val estado_actual: Int) : Estados()
    object MovingDOWN : Estados()
    object Error : Estados()
}