import main.calculator.Calculator

fun main(){
    println("계산기 프로그램에 오신걸 환영합니다!!")

    while(true){
        println()
        println("음수부호와 정수는 반드시 숫자와 붙여서 작성하세요.")
        println("마찬가지로 소숫점의 앞뒤가 비어있어서는 안됩니다.")
        println("올바른 예\n1. (-2.5)\n2. -2.5")
        println("틀린 예\n1. (- 2. 5)\n2. - 2 . 5\n3. -      2 .\n")

        print("수식을 입력하세요: ")
        val input = readLine()!!

        var postfix_stack: ArrayList<String> = toPostfix(input)
        println(postfix_stack)

        var idx: Int = 2
        var current: String
        while(postfix_stack.size > 1){
            current = postfix_stack[idx]
            if((current == "*") || (current == "/") || (current == "+") || (current == "-")){
                postfix_stack.removeAt(idx)

                val b = postfix_stack.removeAt(idx - 1).toFloat()
                val a = postfix_stack.removeAt(idx - 2).toFloat()

                postfix_stack.add(idx - 2, Calculator(a, b, current).calculate().toString())

                idx = 2
            }
            else{
                idx += 1
            }
        }

        println("$input = ${postfix_stack[0]}")
    }
}