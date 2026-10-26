package org.danielcastelao.dam

sealed class Estados {
    object Idle : Estados(){
        fun onEnter(): Int {
            println("Bienvenido al ascensor")
            nivel_actual = 0

            if(nivel_actual== 0) {
                if (nivel_0) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                } else if (nivel_1) {
                    nivel_actual = 2
                    estado_actual = Estados.MovingUP(nivel_actual)

                } else if (nivel_1 && nivel_0) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                }
            } else if (nivel_actual == 1) {
                if (nivel_1) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                } else if (nivel_0) {
                    nivel_actual = 2
                    estado_actual = Estados.MovingDOWN(nivel_actual)

                } else if (nivel_1 && nivel_0) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                }
            }
            else{
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)
            }

            return nivel_actual
        }
        override fun toString(): String {
            return "Idle"
        }
    }
    data class MovingUP(val estado_actual: Int) : Estados(){
        fun onEnter(): Int { nivel_actual = 2
            println("Esta subiendo...")

            if (nivel_0) {
                nivel_actual = -1
                org.danielcastelao.dam.estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1) {
                nivel_actual = -1
                org.danielcastelao.dam.estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1 && nivel_0) {
                nivel_actual = -1
                org.danielcastelao.dam.estado_actual = Estados.Error(nivel_actual)

            }
            else{
                //Si nada falla
                org.danielcastelao.dam.estado_actual = Estados.Idle
            }
            return nivel_actual}
        override fun toString(): String {
            return "MovingUP"
        }
    }
    data class MovingDOWN(val estado_actual: Int) : Estados(){
        fun onEnter(): Int {
            nivel_actual = 2
            println("Esta bajando...")

            if (nivel_0) {
                nivel_actual = -1
                org.danielcastelao.dam.estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1) {
                nivel_actual = -1
                org.danielcastelao.dam.estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1 && nivel_0) {
                nivel_actual = -1
                org.danielcastelao.dam.estado_actual = Estados.Error(nivel_actual)

            }
            else{
                //Si nada falla
                org.danielcastelao.dam.estado_actual = Estados.Idle
            }

            return nivel_actual
        }
        override fun toString(): String {
            return "MovingDOWN"
        }
    }
    data class Error(val estado_actual: Int) : Estados(){
        fun onEnter(): Int {
            nivel_actual = -1
            println("Ha habido un problema, se esta solucionando")
            org.danielcastelao.dam.estado_actual = Estados.Idle
            return nivel_actual
        }
        override fun toString(): String {
            return "Error"
        }
    }
}