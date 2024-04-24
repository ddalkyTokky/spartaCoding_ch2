package main.postfix

import OperatorsEnum

fun infixToPostfix(infix: MutableList<Any>): MutableList<Any>{
    var postifx = mutableListOf<Any>()
    var stack = mutableListOf<OperatorsEnum>()

    val current = infix.iterator()

    while(current.hasNext()){
        val value: Any = current.next()

        if(value is Float){
            postifx.add(value)
        }
        else{
            if(OperatorsEnum.OPEN_PAREN.equals(value)){
                stack.add(value as OperatorsEnum)
            }
            else if(OperatorsEnum.CLOSE_PAREN.equals(value)){
                while(!OperatorsEnum.OPEN_PAREN.equals(stack.last())){
                    postifx.add(stack.removeAt(stack.lastIndex))
                }
                stack.removeAt(stack.lastIndex)
            }
            else {
                if (stack.isEmpty()) {
                    stack.add(value as OperatorsEnum)
                } else {
                    while((value as OperatorsEnum).priority >= stack.last().priority) {

                        postifx.add(stack.removeAt(stack.lastIndex))

                        if(stack.isEmpty()){
                            break
                        }
                    }
                    stack.add(value)
                }
            }
        }
    }

    while(stack.isNotEmpty()){
        postifx.add(stack.removeAt(stack.lastIndex))
    }

    return postifx
}