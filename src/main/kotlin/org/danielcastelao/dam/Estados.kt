package org.danielcastelao.dam

sealed class Estados {
    object Idle : Estados(){
        fun onEnter(){}
        override fun toString(): String {
            return "Idle"
        }
    }
    data class MovingUP(val estado_actual: Int) : Estados(){
        fun onEnter(){}
        override fun toString(): String {
            return "MovingUP"
        }
    }
    data class MovingDOWN(val estado_actual: Int) : Estados(){
        fun onEnter(){}
        override fun toString(): String {
            return "MovingDOWN"
        }
    }
    data class Error(val estado_actual: Int) : Estados(){
        fun onEnter(){}
        override fun toString(): String {
            return "Error"
        }
    }
}