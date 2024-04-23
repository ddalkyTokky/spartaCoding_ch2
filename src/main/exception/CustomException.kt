package main.exception

import Operators

class CustomException(val a: Float, val b: Float, val operator: Operators): IllegalArgumentException() {
    override val message: String? = "\nsomething went wrong, your input was\na: $a\nb: $b\noperator: $operator"
}