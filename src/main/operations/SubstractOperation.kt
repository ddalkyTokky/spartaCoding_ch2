package main.operations

class SubstractOperation(val a: Float, val b: Float): OperationInterface {
    override fun operate(): Float {
//        print("$a - $b = ")
        return a - b
    }
}