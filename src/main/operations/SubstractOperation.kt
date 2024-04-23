package main.operations

import AbstractOperation

class SubstractOperation(a: Float, b: Float): AbstractOperation(a, b) {
    override fun operate(): Float {
        print("$a - $b = ")
        return a - b
    }
}