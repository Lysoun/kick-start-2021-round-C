import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode

fun main(args: Array<String>) {
    val casesNumber = readLine()!!.toInt()

    for (i in 1..casesNumber) {
        println("Case #$i: ${countPossibleValuesForK(BigInteger(readLine()!!))}")
    }
}

fun isValidK(K: BigInteger, G: BigInteger): Boolean {
    val delta = BigDecimal.valueOf(0.25) +
            BigDecimal.valueOf(2) * (((K * (K - BigInteger.ONE)).toBigDecimal() / BigDecimal.valueOf(2)) + G.toBigDecimal())

    if (delta <= ZERO) {
        return false
    }

    val root = BigDecimal.valueOf((-1.0 / 2.0)) + delta.sqrt(MathContext(40, RoundingMode.HALF_UP))

    return root.stripTrailingZeros().scale() <= 0
}

fun countPossibleValuesForK(goldBarsObjective: BigInteger): Int {
    var i = BigInteger.ONE
    var numberOfPossibleValuesForK = 0
    while (i < goldBarsObjective / BigInteger.valueOf(2) + BigInteger.ONE) {
        if (isValidK(i, goldBarsObjective)) {
            ++numberOfPossibleValuesForK
        }
        ++i
    }
    return numberOfPossibleValuesForK + 1
}