package main.operations

class AddOperation(val a: Float, val b: Float): OperationInterface {
    override fun operate(): Float {
//        print("$a + $b = ")
        return a + b
    }
}