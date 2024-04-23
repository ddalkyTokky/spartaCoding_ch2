package main.operations

import AbstractOperation

class AddOperation(a: Float, b: Float): AbstractOperation(a, b) {
    override fun operate(): Float {
        print("$a + $b = ")
        return a + b
    }
}