inline fun symbolToOpenum(ch: Char): OperatorsEnum{
    for(openum in OperatorsEnum.entries){
        if(openum.symbol.equals(ch)){
            return openum
        }
    }
    return OperatorsEnum.UNKNOWN
}