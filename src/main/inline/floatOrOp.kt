inline fun floatOrOp(input: String): Boolean{
    try{
        input.toFloat()
        return true
    }
    catch (e: Exception){
        return false
    }
}