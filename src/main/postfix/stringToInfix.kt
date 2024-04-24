package main.postfix

import symbolToOpenum

fun stringToInfix(input: String): MutableList<Any> {
    var infix = mutableListOf<Any>()

    // ture: 마지막으로 push 된것: -, +, *, /, (
    // false: 마지막으로 push 된것: 0 ~ 9, )
    var lastInsert: Boolean = true

    var numberFound: Boolean = false
    var string_number: String = ""

    for (ch in input) {
        if(ch == ' '){
            if(numberFound){
                numberFound = false
                infix.add(string_number.toFloat())
                string_number = ""
                lastInsert = false
            }
            continue
        }
        else if(('0' <= ch) && ('9' >= ch)){
            numberFound = true
            string_number += ch
        }
        else if(ch == '.'){
            string_number += ch
        }
        else if(ch == '-'){
            if (numberFound) {
                numberFound = false
                infix.add(string_number.toFloat())
                string_number = ""
                lastInsert = false
            }

            if(lastInsert){
                string_number += ch
                lastInsert = false
            }
            else {
                infix.add(symbolToOpenum(ch))
                lastInsert = true
            }
        }
        else if((ch == '+') || (ch == '*') || (ch == '/') || (ch == '(')){
            if(numberFound){
                numberFound = false
                infix.add(string_number.toFloat())
                string_number = ""
            }

            infix.add(symbolToOpenum(ch))
            lastInsert = true
        }
        else if(ch == ')'){
            if(numberFound){
                numberFound = false
                infix.add(string_number.toFloat())
                string_number = ""
            }

            infix.add(symbolToOpenum(ch))
            lastInsert = false
        }
        else{
            throw IllegalArgumentException("\n\nwrong character Found!! $ch")
        }
    }
    if(string_number != ""){
        infix.add(string_number.toFloat())
    }
    return infix
}