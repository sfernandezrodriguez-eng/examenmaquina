package org.danielcastelao.dam

import org.danielcastelao.dam.Gestor.estado_actual
import org.danielcastelao.dam.Gestor.nivel_0
import org.danielcastelao.dam.Gestor.nivel_1
import org.danielcastelao.dam.Gestor.nivel_actual

sealed class Estados {
    object Idle : Estados(){
        fun onEnter(): Int {
            println("Bienvenido al ascensor")

            if(nivel_actual== 0) {
                if (nivel_0.equals(true)) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                } else if (nivel_1.equals(true)) {
                    nivel_actual = 2
                    estado_actual = Estados.MovingUP(nivel_actual)

                } else if (nivel_1.equals(true) && nivel_0.equals(true)) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                }
            } else if (nivel_actual == 1) {
                if (nivel_1.equals(true)) {
                    nivel_actual = -1
                    estado_actual = Estados.Error(nivel_actual)

                } else if (nivel_0.equals(true)) {
                    nivel_actual = 2
                    estado_actual = Estados.MovingDOWN(nivel_actual)

                } else if (nivel_1.equals(true) && nivel_0.equals(true)) {
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
    data class MovingUP(var nivel_actual: Int) : Estados(){
        fun onEnter(): Int { nivel_actual = 2
            println("Esta subiendo...")

            if (nivel_0.equals(true)) {
                nivel_actual = -1
                estado_actual = Error(nivel_actual)

            } else if (nivel_1.equals(true)) {
                nivel_actual = -1
                estado_actual = Error(nivel_actual)

            } else if (nivel_1.equals(true) && nivel_0.equals(true)) {
                nivel_actual = -1
                estado_actual = Error(nivel_actual)

            }
            else{
                //Si nada falla
                estado_actual = Idle
            }
            return nivel_actual}
        override fun toString(): String {
            return "MovingUP"
        }
    }
    data class MovingDOWN(var nivel_actual: Int) : Estados(){
        fun onEnter(): Int {
            nivel_actual = 2
            println("Esta bajando...")

            if (nivel_0.equals(true)) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1.equals(true)) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            } else if (nivel_1.equals(true) && nivel_0.equals(true)) {
                nivel_actual = -1
                estado_actual = Estados.Error(nivel_actual)

            }
            else{
                //Si nada falla
                estado_actual = Estados.Idle
            }

            return nivel_actual
        }
        override fun toString(): String {
            return "MovingDOWN"
        }
    }
    data class Error(var nivel_actual: Int) : Estados(){
        fun onEnter(): Int {
            nivel_actual = -1
            println("Ha habido un problema, se esta solucionando")
            estado_actual = Estados.Idle
            return nivel_actual
        }
        override fun toString(): String {
            return "Error"
        }
    }
}