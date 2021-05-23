fun readLineToInt() = readLine()!!.toInt()

fun main(args: Array<String>) {
    val casesNumber = readLine()!!.toInt()

    for (i in 1..casesNumber) {
        println("Case #$i: ${countPossibleValuesForK(readLineToInt())}")
    }
}

fun countPossibleValuesForK(goldBarsObjective: Int): Int {
    var i = 1
    var numberOfPossibleValuesForK = 0
    while (i <= goldBarsObjective) {
        var j = i
        var sum = 0
        while(sum < goldBarsObjective) {
            sum+=j
            ++j
        }

        if(sum == goldBarsObjective) {
            ++numberOfPossibleValuesForK
        }
        ++i
    }
    return numberOfPossibleValuesForK
}