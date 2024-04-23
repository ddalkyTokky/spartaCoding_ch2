package main.exception

class CustomException(val input: String): IllegalArgumentException() {
    override val message: String? = "\nsomething went wrong, your input was: $input"
}