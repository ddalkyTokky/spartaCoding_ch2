# 1. 결과화면

![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/ee774188-2ed7-4552-a03a-4a357db43dab)

# 2. 작동흐름

![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/9af1c58a-23ff-40a4-a242-4b8f910f9f4b)

# 3. 패키지설명

## A. operations package
아주 간단한 인터페이스와 두 수 연산을 진행하는 코드로 이루어진 패키지이다.

## B. calculator package
### B-1. calculator.Calculator.kt
만들어진 Operations 패키지를 사용해 두수 연산을 진행하는 파일이다.

### B-2. calculator.OperatorsEnum.kt
각 연산자의 심볼과 우선순위를 나열한 Enum Class이다.               
심볼과 우선순위는 아래 부분에서 중요하게 사용된다.              
1. string형식의 연산자 심볼과 해당 Enum을 매칭시킬때              
2. Infix 를 Postfix로 바꾸면서 연산자의 우선순위를 고려할때              
![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/eb696501-7c98-4c86-bce6-481f75234b4f)

## C. inline package

### C-1. floatOrOp.kt
문자열이 정수변환이 가능한지 판단한다.
정수변환이 가능 : true
정수변환 불가능 : false

### C-2. symbolToOpenum.kt
문자열로 된 연산자 심볼을 OperatorsEnum 타입으로 바꾼다.              
OperatorsEnum.symbol 중 문자열과 매칭하는 것이 있을때 : 해당 OperatorsEnum 반환              
OperatorsEnum.symbol 중 문자열과 매칭하는 것이 없을때 : OperatorsEnum.UNKNOWN 반환              

## D. postfix package
### D-1. stringToinfix.kt
String을 받아 infix MutableList를 반환한다.           
정말 순수하게 반복문 문자열 parsing 알고리즘이다. 이 이상 설명할 말이 없다..            
몇 가지 특징을 꼽을 수는 있는데, 다음과 같다.            
#### var lastInsert: Boolean = false
해당 변수는 '-'가 등장했을때, 음수부호인지, 연산자인지를 판단하기 위한 것이다.            
'-' 부호 이전에 온것이 - + * / ( 중 하나라면 음수부호이다.            
'-' 부호 이전에 온것이 0 ~ 9 ) 중 하나라면 연산자이다.            
#### var numberFound: Boolean = false
숫자인 문자를 발견하여 숫자를 기록중이었는지 나타낸다.            
숫자가 끝나면 기록된 문자열을 infix 에 넣는다.            

### D-2. infixToPostfix.kt
infix MutableList을 받아 postfix MutableList를 반환한다.           
규칙은 다음과 같다.

[참고: 중위표기법과 후위 표기법](https://todaycode.tistory.com/73)

연산규칙
1. 숫자는 그대로 출력한다.
2. 만약 스택이 비어있다면 연산자를 그냥 스택에 넣는다.
3. (스택의 top에 있는 연산자의 우선순위 < 현재 연산자의 우선순위) 이면 현재 연산자를 그냥 스택에 넣는다.
4. (스택의 top에 있는 연산자의 우선순위 >= 현재 연산자의 우선순위) 이면 2번 혹은 3번 상황이 될 때까지 pop 하여 출력하고 연산자를 스택에 넣는다.
5. 우선순위는 (괄호 연산자) < (더하기=빼기) < (곱하기=나누기)이다.
6. 여는 괄호는 스택에 그냥 추가한다.
7. 닫는 괄호는 여는 괄호가 나올 때까지 스택을 pop 하여 출력한다. 다 출력하고 난 뒤 괄호들은 버린다.
8. 모든 수식을 다 사용했다면 스택이 빌 때까지 pop하여 출력한다.

### D-3. stringToPostfix.kt
string을 받아 postfix MutableList를 반환한다.
위 두 함수를 그대로 사용한다.

# 4. main.kt
위 모든 패키지들을 활용하여 입력값을 postfix MutableList로 바꾼다음, 연산을 진행한다.           
1. 리스트 가장 앞에 오는 연산자를 찾는다. (연산자 리스트에서 제거)
2. 연산자 바로 앞 두 수를 연산자를 이용해 연산한다. (두 수 리스트에서 제거)
3. 연산 결과를 다시 넣는다 (두 수 중 앞 수가 위치했던 인덱스에 삽입)
4. 리스트가 3개 미만의 길이를 가지게 되면 중단
