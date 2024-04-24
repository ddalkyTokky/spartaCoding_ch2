package main.postfix

fun stringToPostfix(input: String): MutableList<String>{
    val infix: MutableList<String> = stringToInfix(input)

    println("this is your infix stack: $infix")

    return infixToPostfix(infix)
}