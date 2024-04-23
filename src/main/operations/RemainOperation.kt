package main.operations

import AbstractOperation

class RemainOperation(a: Float, b: Float): AbstractOperation(a, b) {
    override fun operate(): Float {
        if(b.equals(0.toFloat())){
            println("WARNING!!! Cannot divide by 0")
        }
        print("$a % $b = ")
        return a % b
    }
}