package main.calculator

import OperatorsEnum
import main.operations.*

object Calculator {
    fun calculate(a: Float, b: Float, operator: OperatorsEnum): Float {
        if (OperatorsEnum.ADD.equals(operator)) {
            return (AddOperation.operate(a, b))
        } else if (OperatorsEnum.SUB.equals(operator)) {
            return (SubstractOperation.operate(a, b))
        } else if (OperatorsEnum.MULTI.equals(operator)) {
            return (MultiplyOperation.operate(a, b))
        } else if (OperatorsEnum.DIV.equals(operator)) {
            return (DivideOperation.operate(a, b))
        } else {
            throw IllegalArgumentException("\n\nUnknown operator\n\n")
        }
    }
}