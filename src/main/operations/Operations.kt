fun interface OperationInterface{
    fun operate(a: Float, b:Float): Float
}

val addOperation =  OperationInterface{ a: Float, b: Float -> a + b }

val substractOperation =  OperationInterface{ a: Float, b: Float -> a - b }

val multiplyOperation =  OperationInterface{ a: Float, b: Float -> a * b }

val divideOperation =  OperationInterface{ a: Float, b: Float -> a / b }
