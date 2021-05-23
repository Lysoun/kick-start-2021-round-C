import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun readLineToInt() = readLine()!!.toInt()

fun main(args: Array<String>) {
    val casesNumber = readLine()!!.toInt()

    for (i in 1..casesNumber) {
        println("Case #$i: ${countPossibleValuesForK(readLineToInt())}")
    }
}

fun isValidK(K: BigInteger, G: BigInteger): Boolean {
    val delta = BigDecimal.valueOf(0.25) +
            BigDecimal.valueOf(2) * (((K * (K - BigInteger.ONE)).toBigDecimal() / BigDecimal.valueOf(2)) + G.toBigDecimal())

    if(delta <= ZERO) {
        return false
    }

    val root = BigDecimal.valueOf((-1.0/2.0)) + delta.sqrt(MathContext(4, RoundingMode.HALF_UP))

    return root.toBigInteger() != K && root.stripTrailingZeros().scale() <= 0
}

fun countPossibleValuesForK(goldBarsObjective: Int): Int {
    var i = BigInteger.ONE
    var numberOfPossibleValuesForK = 0
    val goldBarsObjectiveBigInteger =  BigInteger.valueOf(goldBarsObjective.toLong())
    while (i < goldBarsObjectiveBigInteger) {
        if(isValidK(i, goldBarsObjectiveBigInteger)) {
            ++numberOfPossibleValuesForK
        }
        ++i
    }
    return numberOfPossibleValuesForK+1
}