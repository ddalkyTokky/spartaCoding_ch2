package main.operations

object DivideOperation: OperationInterface {
    override fun operate(a: Float, b: Float): Float {
        if(b.equals(0.toFloat())){
            println("WARNING!!! Cannot divide by 0")
        }
//        print("$a / $b = ")
        return a / b
    }
}