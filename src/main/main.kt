import main.calculator.Calculator
//import main.exception.CustomException

//inline fun <reified T : Enum<T>> stringToOperators(type: String, default: T): T {
//    return try {
//        java.lang.Enum.valueOf(T::class.java, type)
//    } catch (e: IllegalArgumentException) {
//        default
//    }
//}

fun main(){
    println("계산기 프로그램에 오신걸 환영합니다!!")
    while(true){

        var a: Float
        while(true) {
            println("첫 수 a를 입력해주세요!")
            try {
                a = readLine()!!.toFloat()
                break
            } catch (e: NumberFormatException) {
                println("잘못된 인수입니다. 다시 입력하세요!")
                continue
            }
        }

        var b: Float
        while(true) {
            println("두번째 수 b를 입력해주세요!")
            try {
                b = readLine()!!.toFloat()
                break
            }
            catch (e: NumberFormatException){
                println("잘못된 인수입니다. 다시 입력하세요!")
                continue
            }
        }

        var operator: Operators
        while(true) {
            println("무슨 연산을 하실건가요?")
            println("1. ADD (덧셈), 2. SUB (뺄셈) 3. MULTI (곱셈) 4. DIV (나누기) 5. REM (나머지연산)")
            try{
                operator = Operators.valueOf(readLine()!!)
                break
            }
            catch (e: Exception){
                println("잘못된 인수입니다. 다시 입력하세요!")
                continue
            }
        }

        println(Calculator(a, b, operator).calculate())
    }
}