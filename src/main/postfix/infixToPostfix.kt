package main.postfix

import OperatorsEnum
import floatOrOp
import symbolToOpenum

fun infixToPostfix(infix: MutableList<String>): MutableList<String>{
    var postifx = mutableListOf<String>()
    var stack = mutableListOf<String>()

    val current = infix.iterator()

    while(current.hasNext()){
        val value: String = current.next()

        if(floatOrOp(value)){
            postifx.add(value)
        }
        else{
            val op: OperatorsEnum = symbolToOpenum(value)

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