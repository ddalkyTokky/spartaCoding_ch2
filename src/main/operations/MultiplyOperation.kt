package main.operations

object MultiplyOperation: OperationInterface {
    override fun operate(a: Float, b: Float): Float {
//        print("$a * $b = ")
        return a * b
    }
}