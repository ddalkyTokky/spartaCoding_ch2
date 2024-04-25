package main.operations

object SubstractOperation: OperationInterface {
    override fun operate(a: Float, b: Float): Float {
//        print("$a - $b = ")
        return a - b
    }
}