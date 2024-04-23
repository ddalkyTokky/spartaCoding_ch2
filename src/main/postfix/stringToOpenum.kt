inline fun stringToOpenum(str:String): OperatorsEnum{
    for(openum in OperatorsEnum.values()){
        if(openum.symbol.toString().equals(str)){
            return openum
        }
    }
    return OperatorsEnum.UNKNOWN
}