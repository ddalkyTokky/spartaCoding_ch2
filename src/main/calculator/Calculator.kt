package main.calculator

import OperatorsEnum
import addOperation
import divideOperation
import multiplyOperation
import substractOperation

object Calculator {
    fun calculate(a: Float, b: Float, operator: OperatorsEnum): Float {
        if (OperatorsEnum.ADD.equals(operator)) {
            return (addOperation.operate(a, b))
        } else if (OperatorsEnum.SUB.equals(operator)) {
            return (substractOperation.operate(a, b))
        } else if (OperatorsEnum.MULTI.equals(operator)) {
            return (multiplyOperation.operate(a, b))
        } else if (OperatorsEnum.DIV.equals(operator)) {
            return (divideOperation.operate(a, b))
        } else {
            throw IllegalArgumentException("\n\nUnknown operator\n\n")
        }
    }
}