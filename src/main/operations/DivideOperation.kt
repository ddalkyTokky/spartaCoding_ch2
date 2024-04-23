package main.operations

class DivideOperation(val a: Float, val b: Float): OperationInterface {
    override fun operate(): Float {
        if(b.equals(0.toFloat())){
            println("WARNING!!! Cannot divide by 0")
        }
        print("$a / $b = ")
        return a / b
    }
}