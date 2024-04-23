package main.postfix

import OperatorsEnum
import floatOrOp
import stringToOpenum

class Postfix (){

    private fun stringToInfix(input: String): MutableList<String> {
        var infix = mutableListOf<String>()

        // ture: 마지막으로 push 된것: -, +, *, /, (
        // false: 마지막으로 push 된것: 0 ~ 9, )
        var lastInsert: Boolean = true

        var numberFound: Boolean = false
        var string_number: String = ""

        for (ch in input) {
            if(ch == ' '){
                if(numberFound){
                    numberFound = false
                    infix.add(string_number)
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
                    infix.add(string_number)
                    string_number = ""
                    lastInsert = false
                }

                if(lastInsert){
                    string_number += ch
                    lastInsert = false
                }
                else {
                    infix.add(ch.toString())
                    lastInsert = true
                }
            }
            else if((ch == '+') || (ch == '*') || (ch == '/') || (ch == '(')){
                if(numberFound){
                    numberFound = false
                    infix.add(string_number)
                    string_number = ""
                }

                infix.add(ch.toString())
                lastInsert = true
            }
            else if(ch == ')'){
                if(numberFound){
                    numberFound = false
                    infix.add(string_number)
                    string_number = ""
                }

                infix.add(ch.toString())
                lastInsert = false
            }
            else{
                throw IllegalArgumentException("\n\nwrong character Found!! $ch")
            }
        }
        if(string_number != ""){
            infix.add(string_number)
        }
        return infix
    }

    private fun infixToPostfix(infix: MutableList<String>): MutableList<String>{
        var postifx = mutableListOf<String>()
        var stack = mutableListOf<String>()

        val current = infix.iterator()

        while(current.hasNext()){
            val value: String = current.next()
            
            if(floatOrOp(value)){
                postifx.add(value)
            }
            else{
                val op: OperatorsEnum = stringToOpenum(value)

                if(OperatorsEnum.OPEN_PAREN.equals(op)){
                    stack.add(op.toString())
                }
                else if(OperatorsEnum.CLOSE_PAREN.equals(op)){
                    while(!OperatorsEnum.valueOf(stack.last()).equals(OperatorsEnum.OPEN_PAREN)){
                        postifx.add(stack.removeAt(stack.lastIndex))
                    }
                    stack.removeAt(stack.lastIndex)
                }
                else {
                    if (stack.isEmpty()) {
                        stack.add(op.toString())
                    } else {
                            while(op.priority >= OperatorsEnum.valueOf(stack.last()).priority) {

                                postifx.add(stack.removeAt(stack.lastIndex))

                                if(stack.isEmpty()){
                                    break
                                }
                            }
                        stack.add(op.toString())
                    }
                }
            }
        }

        while(stack.isNotEmpty()){
            postifx.add(stack.removeAt(stack.lastIndex))
        }

        return postifx
    }

    public fun stringToPostfix(input: String): MutableList<String>{
        val infix: MutableList<String> = stringToInfix(input)

        println("this is your infix stack: $infix")

        return infixToPostfix(infix)
    }
}