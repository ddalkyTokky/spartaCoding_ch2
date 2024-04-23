package main.calculator

import OperatorsEnum
import main.operations.*

class Calculator(val a: Float, val b: Float, val operator: OperatorsEnum) {
    fun calculate(): Float {
        if (OperatorsEnum.ADD.equals(operator)) {
            return (AddOperation(a, b).operate())
        }
        else if (OperatorsEnum.SUB.equals(operator)) {
            return (SubstractOperation(a, b).operate())
        }
        else if (OperatorsEnum.MULTI.equals(operator)) {
            return (MultiplyOperation(a, b).operate())
        }
        else if (OperatorsEnum.DIV.equals(operator)) {
            return (DivideOperation(a, b).operate())
        }
        else{
            throw IllegalArgumentException("\n\nUnknown operator\n\n")
        }
    }
}