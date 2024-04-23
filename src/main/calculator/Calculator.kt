package main.calculator

import Operators
import main.exception.CustomException
import main.operations.*

class Calculator(val a: Float, val b: Float, val operator: Operators) {
    fun calculate(): Float {
        if (Operators.ADD.equals(operator)) {
            return (AddOperation(a, b).operate())
        }
        else if (Operators.SUB.equals(operator)) {
            return (SubstractOperation(a, b).operate())
        }
        else if (Operators.MULTI.equals(operator)) {
            return (MultiplyOperation(a, b).operate())
        }
        else if (Operators.DIV.equals(operator)) {
            return (DivideOperation(a, b).operate())
        }
        else if (Operators.REM.equals(operator)) {
            return (RemainOperation(a, b).operate())
        }
        throw CustomException(a, b, operator)
    }
}
