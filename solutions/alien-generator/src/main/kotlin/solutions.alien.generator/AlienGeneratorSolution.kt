fun readLineToInt() = readLine()!!.toInt()

fun main(args: Array<String>) {
    val casesNumber = readLine()!!.toInt()

    for (i in 1..casesNumber) {
        println("Case #$i: ${countPossibleValuesForK(readLineToInt())}")
    }
}

fun countPossibleValuesForK(goldBarsObjective: Int): Int {
    return 0
}