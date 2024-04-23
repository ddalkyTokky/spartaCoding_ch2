package main.calculator

import main.exception.CustomException
import main.operations.*

class Calculator(val a: Float, val b: Float, val operator: String) {
    fun calculate(): Float {
        if (operator == "+") {
            return (AddOperation(a, b).operate())
        }
        else if (operator == "-") {
            return (SubstractOperation(a, b).operate())
        }
        else if (operator == "*") {
            return (MultiplyOperation(a, b).operate())
        }
        else if (operator == "/") {
            return (DivideOperation(a, b).operate())
        }
        throw CustomException("$a $b $operator")
    }
}