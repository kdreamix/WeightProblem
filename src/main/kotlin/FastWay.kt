class FastWay (val max: Int = 40) {
    private fun getRange(n:Int) = 3*n + 1
    private fun getWeight(n:Int) = 2*n + 1
    private val result = mutableListOf(1)

    fun compute(firstRange:Int = 1): MutableList<Int> {
        if (firstRange >= max) return result
        result += getWeight(firstRange)
        val nextRange = getRange(firstRange)
        return compute(nextRange)
    }
}