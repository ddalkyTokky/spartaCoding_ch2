package main.operations

import AbstractOperation

class MultiplyOperation(a: Float, b: Float): AbstractOperation(a, b) {
    override fun operate(): Float {
        print("$a * $b = ")
        return a * b
    }
}