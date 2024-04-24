import main.calculator.Calculator
import main.postfix.stringToPostfix

fun main(){
    println("계산기 프로그램에 오신걸 환영합니다!!")

    while(true){
        println()
        println("음수부호와 정수는 반드시 숫자와 붙여서 작성하세요.")
        println("마찬가지로 소숫점의 앞뒤가 비어있어서는 안됩니다.")
        println("올바른 예\n1. (-2.5)\n2. -2.5")
        println("틀린 예\n1. (- 2. 5)\n2. - 2 . 5\n3. -      2 .\n")

        print("수식을 입력하세요: ")
        val input = readLine() ?: ""

        var postfix: MutableList<Any> = stringToPostfix(input)
        println("this is your postfix stack: $postfix")

        var idx: Int = 2
        while(postfix.size > 2){
            val value = postfix[idx]

            if(value is OperatorsEnum){
                postfix.removeAt(idx)

                val b = postfix.removeAt(idx - 1) as Float
                val a = postfix.removeAt(idx - 2) as Float

                postfix.add(idx - 2, Calculator(a, b, value).calculate())

                idx = 2
            }
            else{
                idx += 1
            }
        }

        println("$input = ${postfix[0]}")
    }
}

private fun Any.toOperatorsEnum(): OperatorsEnum {
    for(openum in OperatorsEnum.entries){
        if(openum.symbol.equals(this as Char)){
            return openum
        }
    }
    return OperatorsEnum.UNKNOWN
}