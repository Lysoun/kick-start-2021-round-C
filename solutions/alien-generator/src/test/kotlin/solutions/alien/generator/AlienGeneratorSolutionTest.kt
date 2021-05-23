import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class AlienGeneratorSolutionTest {
    @TestFactory
    fun `given gold bars objective, should count all the possible K values to reach it exactly`() =
        listOf(
            10 to 2,
            125 to 4
        ).map { (G, expected) ->
            dynamicTest(
                "given gold bars objective, should count all the possible K values to reach it exactly"
            ) {
                expectThat(countPossibleValuesForK(G)).isEqualTo(expected)
            }
        }
}