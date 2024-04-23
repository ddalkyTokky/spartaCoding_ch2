enum class  OperatorsEnum(val symbol: Char, val priority: Int) {
    ADD('+', 1),
    SUB('-', 1),
    MULTI('*', 0),
    DIV('/', 0),
    OPEN_PAREN('(', 2),
    CLOSE_PAREN(')', 2),
    UNKNOWN( ' ', 3)
}