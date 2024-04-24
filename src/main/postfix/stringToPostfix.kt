package main.postfix

fun stringToPostfix(input: String): MutableList<Any>{
    val infix: MutableList<Any> = stringToInfix(input)

    println("this is your infix stack: $infix")

    return infixToPostfix(infix)
}