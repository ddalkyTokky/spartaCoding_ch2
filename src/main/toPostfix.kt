import main.exception.CustomException

fun toPostfix(input: String): ArrayList<String> {
    //최종 반활될 후위연산식
    var postfix_stack = ArrayList<String>()
    //연산자 스택
    var stack = ArrayList<Char>()

    // 참고 링크: https://todaycode.tistory.com/73

    //문자열을 뒤지기 시작할 인덱스 (항상 증가하는 것이 아니라 따로 관리한다.)
    var idx: Int = 0
    //현재 문자값
    var current: Char
    //'(' 기호가 나타났는지 확인하는 용도
    // ( 다음에 오는 연산자는 무조건 스택에 넣는다.
    var open_paren_flag: Boolean = false
    //음수부호가 있었다면, true
    var minus_flag: Boolean = false

    //'-' 가 음수 부호냐 아니면 연산자이냐를 판단하기 위함
    // - 부호 전에 마지막으로 push 된것이 아래와 같다면, 값을 아래로 바꾼다.
    // - 직전에 나온 기호가 무엇인지를 파악하는 것.

    // ture: 마지막으로 push 된것: -, +, *, /, (
    // false: 마지막으로 push 된것: 0 ~ 9, )
    var last_insert: Boolean = true

    while(idx != input.length) {
        current = input[idx]

        // 공백은 무시!!
        if(current == ' '){
            idx += 1
            continue
        }
        // 숫자 라면.
        else if(('0' <= current) && ('9' >= current)){
            // 해당 문자가 문자열의 끝이라면,
            if(idx == (input.length - 1)){
                // 음수라면,
                if(minus_flag){
                    postfix_stack.add("-" + current.toString())
                    minus_flag = false
                }
                else {
                    postfix_stack.add(current.toString())
                }
                idx += 1
            }

            //뒤에 문자 (숫자)가 더 남았다면,
            else{
                var result: Float = Character.getNumericValue(current).toFloat()

                idx += 1
                current = input[idx]

                // 숫자인 한, 계속 x10 하며 쌓기
                while(('0' <= current) && ('9' >= current)) {
                    result *= 10
                    result += Character.getNumericValue(current).toFloat()

                    idx += 1
                    if(idx == input.length){
                        break
                    }
                    current = input[idx]
                }

                //문자열의 끝이 아니라면
                if(idx != input.length){
                    // 숫자뒤에 나온 문자가 '.' 소수점 이라면,
                    if(current == '.'){
                        idx += 1
                        current = input[idx]
                        var temp: Float = 0.1f

                        // 다시한번 x0.1 하며 소수점 자리를 모은다.
                        while(('0' <= current) && ('9' >= current)) {
                            result += (Character.getNumericValue(current).toFloat() * temp)

                            temp *= 0.1f

                            idx += 1
                            if(idx == input.length){
                                break
                            }
                            current = input[idx]
                        }
                    }
                }

                // 모두 모았으면 음수부호 붙여서 스택에 push!
                if(minus_flag){
                    postfix_stack.add("-" + result.toString())
                    minus_flag = false
                }
                else {
                    postfix_stack.add(result.toString())
                }
            }
            last_insert = false
        }
        // '-'라면,
        else if(current == '-') {
            // 마지막 기호가 무엇이었나에 따라 음수부호인지 판별
            if(last_insert) {
                minus_flag = true
                idx += 1
            }
            else{
                if(open_paren_flag){
                    open_paren_flag = false
                    stack.add(current)
                    idx += 1
                    last_insert = true
                }
                else{
                    // 스택이 비었다면 일단 스택에 넣기.
                    if(stack.isEmpty()){
                        stack.add(current)
                        idx += 1
                        last_insert = true
                    }
                    // 항상 *, / 보다 우선순위가 밀리기 때문에
                    // 스택이 있었다면, 스택의 것부터 꺼내줘야한다.
                    else{
                        postfix_stack.add(stack.removeAt(stack.lastIndex).toString())
                    }
                }
            }
        }
        else if(current == '+') {
            if(open_paren_flag){
                open_paren_flag = false
                stack.add(current)
                idx += 1
                last_insert = true
            }
            else{
                if(stack.isEmpty()){
                    stack.add(current)
                    idx += 1
                    last_insert = true
                }
                else{
                    postfix_stack.add(stack.removeAt(stack.lastIndex).toString())
                }
            }
        }
        else if((current == '*') || (current == '/')) {
            if(open_paren_flag){
                open_paren_flag = false
                stack.add(current)
                idx += 1
                last_insert = true
            }
            else {
                if (stack.isEmpty()) {
                    stack.add(current)
                    idx += 1
                    last_insert = true
                } else {
                    if ((stack[stack.lastIndex] == '+') || ((stack[stack.lastIndex] == '-'))) {
                        stack.add(current)
                        idx += 1
                        last_insert = true
                    } else {
                        postfix_stack.add(stack.removeAt(stack.lastIndex).toString())
                    }
                }
            }
        }
        else if(current == '('){
            stack.add(current)
            idx += 1
            open_paren_flag = true
            last_insert = true
        }
        else if(current == ')'){
            var local_current = stack.removeAt(stack.lastIndex)
            while(local_current != '('){
                postfix_stack.add(local_current.toString())
                local_current = stack.removeAt(stack.lastIndex)
            }
            idx += 1
            last_insert = false
        }

        else{
            throw CustomException(input)
        }
    }
    for(i in 0 until stack.size){
        postfix_stack.add(stack.removeAt(stack.lastIndex).toString())
    }

    return postfix_stack
}