# 1. 결과화면

![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/ee774188-2ed7-4552-a03a-4a357db43dab)

# 2. 작동흐름

![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/9af1c58a-23ff-40a4-a242-4b8f910f9f4b)

# 3. 패키지설명

## 3-1. operations
![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/7d2e028b-a0ef-4fa7-bb28-b5df118cc41a)

아주 간단한 인터페이스와 두 수 연산을 진행하는 코드로 이루어진 패키지이다.

----

## 3-2. calculator
### 3-2-1. calculator.Calculator

![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/9ad5d274-be26-4a96-975e-e2d4d6664cfa)

만들어진 Operations 패키지를 사용해 두수 연산을 진행하는 파일이다.

### 3-2-2. calculator.OperatorsEnum

![image](https://github.com/spartaCoding-2-4/ch2.SoonYong/assets/47583083/eb696501-7c98-4c86-bce6-481f75234b4f)

각 연산자의 심볼과 우선순위를 나열한 Enum Class이다.
심볼과 우선순위는 아래 부분에서 중요하게 사용된다.

1. string형식의 연산자 심볼과 해당 Enum을 매칭시킬때
2. Infix 를 Postfix로 바꾸면서 연산자의 우선순위를 고려할때

----

## 3-3. In
