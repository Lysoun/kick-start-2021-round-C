import java.math.BigInteger

fun readLineToInt() = readLine()!!.toInt()

fun main(args: Array<String>) {
    val casesNumber = readLine()!!.toInt()

    for (i in 1..casesNumber) {
        println("Case #$i: ${countPossibleValuesForK(readLineToInt())}")
    }
}

fun countPossibleValuesForK(goldBarsObjective: Int): Int {
    var i = BigInteger.ONE
    var numberOfPossibleValuesForK = 0
    val goldBarsObjectiveBigInteger =  BigInteger.valueOf(goldBarsObjective.toLong())
    while (i <= goldBarsObjectiveBigInteger) {
        var j = i
        var sum = BigInteger.ZERO
        while(sum < goldBarsObjectiveBigInteger) {
            sum+=j
            ++j
        }

        if(sum == goldBarsObjectiveBigInteger) {
            ++numberOfPossibleValuesForK
        }
        ++i
    }
    return numberOfPossibleValuesForK
}