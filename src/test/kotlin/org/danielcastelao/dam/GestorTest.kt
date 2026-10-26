package org.danielcastelao.dam

import org.danielcastelao.dam.Gestor.estado_actual
import org.danielcastelao.dam.Gestor.gestor
import org.danielcastelao.dam.Gestor.nivel_0
import org.danielcastelao.dam.Gestor.nivel_1
import org.danielcastelao.dam.Gestor.nivel_actual
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GestorTest {
    @AfterTest
    fun restaurarEstado() {
        estado_actual = Estados.Idle
        nivel_actual = 0
    }

    @Test
    fun estadoIdle() {
        estado_actual = Estados.Idle
        nivel_actual = 0

        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
    }

    @Test
    fun pasandoMovingUp() {
        estado_actual = Estados.Idle
        nivel_actual = 0
        Botonera.nivel_0.equals(false)
        Botonera.nivel_1.equals(true)
        Gestor.gestor()

        assertEquals(
            Estados.MovingUP(nivel_actual),
            Gestor.estado_actual
        )
    }

    @Test
    fun pasandoMovingDown() {
        estado_actual = Estados.Idle
        nivel_actual = 1
        Botonera.nivel_0.equals(false)
        Botonera.nivel_1.equals(true)
        Gestor.gestor()

        assertEquals(
            Estados.MovingUP(nivel_actual),
            Gestor.estado_actual
        )
    }

    @Test
    fun pasandoMovingUpAIdle() {
        estado_actual = Estados.MovingUP(nivel_actual)
        nivel_actual = 2
        nivel_0.equals(false)
        nivel_1.equals(false)
        Gestor.gestor()

        assertEquals(
            Estados.Idle,
            Gestor.estado_actual
        )
    }

    @Test
    fun pasandoMovingDownAIdle() {
        estado_actual = Estados.MovingDOWN(nivel_actual)
        nivel_actual = 2
        nivel_0.equals(false)
        nivel_1.equals(false)
        Gestor.gestor()

        assertEquals(
            Estados.Idle,
            Gestor.estado_actual
        )
    }

    @Test
    fun estadoIdleAError() {
        estado_actual = Estados.Idle
        nivel_actual = 1
        nivel_0.equals(true)
        nivel_1.equals(true)
        Gestor.gestor()

        assertEquals(
            Estados.Error(nivel_actual),
            Gestor.estado_actual
        )
    }

    @Test
    fun pasandoMovingDownAError() {
        estado_actual = Estados.MovingDOWN(nivel_actual)
        nivel_actual = 2
        nivel_0.equals(true)
        nivel_1.equals(true)
        Gestor.gestor()

        assertEquals(
            Estados.Error(nivel_actual),
            Gestor.estado_actual
        )
    }




}
