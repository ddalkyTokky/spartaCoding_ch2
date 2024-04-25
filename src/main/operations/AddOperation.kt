package main.operations

object AddOperation: OperationInterface {
    override fun operate(a: Float, b: Float): Float {
//        print("$a + $b = ")
        return a + b
    }
}