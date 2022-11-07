class Fraction {
    private var numerator = 0
    private var denominator = 1

    constructor(n: Int, d: Int) {
        numerator = n
        denominator = d
    }

    constructor(n: Int) {
        numerator = n
        denominator = 1
    }

    constructor(Fr: Fraction) {
        numerator = Fr.numerator
        denominator = Fr.denominator
    }

    constructor(fl: Double) {
        var a = fl
        var b = 1
        while (a % 1 != 0.0){
            a *= 10
            b *= 10
        }
        numerator = a.toInt()
        denominator = b
        norm()
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b
            } else {
                b %= a
            }
        }
        return (a + b)
    }

    fun norm() {
        val thisGcd = gcd(numerator, denominator)
        numerator /= thisGcd
        denominator /= thisGcd
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    fun toDecimal(): Double {
        return numerator.toDouble() / denominator
    }

    fun sum(fr: Fraction){
        val nok = (denominator * fr.denominator) / gcd(denominator, fr.denominator)
        numerator = numerator * nok / denominator + fr.numerator * nok / fr.denominator
        denominator = nok
        norm()
    }

    fun mult(fr: Fraction){
        numerator *= fr.numerator
        denominator *= fr.denominator
        norm()
    }

}