package com.example.fernando.hellokotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun k(v: Int) : Int {
        return v
    }

    fun f(g : (m: Int) -> Int) {
        println(g(555))
    }


    fun z(): Int {
        return 10;
    }

    fun x() : () -> Int {
        return ::z
    }

    @Test
    fun addition_isCorrect() {
        f(::k)
        println(x()())
        assertEquals(4, 2 + 2)
    }

}
