val range = 1..40

fun main(args: Array<String>) {


    for (i in 1..1000000) {
        val result = FastWay(i).compute()
        println("$i need:$result")


    }

    //var candidate = Array(4) { 0 }
    //var validArray = Array(40) { false }

    //candidate = bruteForce(validArray, candidate)

    //candidate.forEach {
    //    println("Ans:$it")
    //}
}

private fun bruteForce(
    validArray: Array<Boolean>,
    candidate: Array<Int>
): Array<Int> {
    var validArray1 = validArray
    var candidate1 = candidate
    range.forEach top@{ a ->
        range.forEach { b ->
            range.forEach { c ->
                range.forEach { d ->
                    range.forEachIndexed closest@{ i, target ->
                        println("Target: $target")
                        val valid = valid(target, a, b, c, d)
                        if (!valid) {
                            println("Invalid found $a,$b,$c,$d ")

                            validArray1 = Array(40) { false }
                            return@closest
                        }
                        if (valid) {
                            println("valid found $a,$b,$c,$d")
                            validArray1[i] = true
                        }
                        val allValid = false !in validArray1

                        if (allValid) {
                            candidate1 = arrayOf(a, b, c, d)
                            println("Ans found")
                        }
                    }
                }
            }
        }
    }
    return candidate1
}

fun valid(target: Int, a: Int, b: Int, c: Int, d: Int): Boolean {
    return oneDigit(target, a)
            || oneDigit(target, b)
            || oneDigit(target, c)
            || oneDigit(target, d)
            || twoDigit(target, a, b)
            || twoDigit(target, a, c)
            || twoDigit(target, a, d)
            || twoDigit(target, b, c)
            || twoDigit(target, b, d)
            || twoDigit(target, c, d)
            || threeDigit(target, a, b, c)
            || threeDigit(target, a, b, d)
            || threeDigit(target, a, c, b)
            || threeDigit(target, a, c, d)
            || threeDigit(target, a, d, b)
            || threeDigit(target, a, d, c)
            || threeDigit(target, b, c, d)

            || fourDigit(target, a, b, c, d)
            || fourDigit(target, a, b, d, c)
            || fourDigit(target, a, c, b, d)
            || fourDigit(target, a, c, d, b)
            || fourDigit(target, a, d, b, c)
            || fourDigit(target, a, d, c, b)
            || fourDigit(target, b, a, c, d)
            || fourDigit(target, b, a, d, c)
            || fourDigit(target, b, c, a, d)
            || fourDigit(target, b, c, d, a)
            || fourDigit(target, b, d, a, c)
            || fourDigit(target, b, d, c, a)
            || fourDigit(target, c, a, b, d)
            || fourDigit(target, c, a, d, b)
            || fourDigit(target, c, b, a, d)
            || fourDigit(target, c, b, d, a)
            || fourDigit(target, c, d, a, b)
            || fourDigit(target, c, d, b, a)
            || fourDigit(target, d, c, b, a)
            || fourDigit(target, d, c, a, b)
            || fourDigit(target, d, b, a, c)
            || fourDigit(target, d, b, c, a)
            || fourDigit(target, d, a, c, b)
            || fourDigit(target, d, a, b, c)

}

fun oneDigit(t: Int, a: Int): Boolean {
    return a == t

}

fun twoDigit(t: Int, a: Int, b: Int): Boolean {
    return t == a + b || t == a - b || t == b - a
}

fun threeDigit(t: Int, a: Int, b: Int, c: Int): Boolean {
    return t == a + b + c
            || t == a + b - c
            || t == a - b - c
            || t == a - b + c
            || t == b - a + c
            || t == b + a - c
            || t == b - a - c
            || t == c + a - b
            || t == c - a + b
            || t == c - b - a

}

fun fourDigit(t: Int, a: Int, b: Int, c: Int, d: Int): Boolean {
    return t == a + b + c + d
            || t == a + b + c - d
            || t == a + b - c + d
            || t == a + b - c - d
            || t == a - b + c + d
            || t == a - b + c - d
            || t == a - b - c + d
            || t == a - b - c - d

            || t == b + a + c - d
            || t == b + a - c + d
            || t == b + a - c - d
            || t == b - a + c + d
            || t == b - a + c - d
            || t == b - a - c + d
            || t == b - a - c - d

            || t == c + a + b - d
            || t == c + a - b + d
            || t == c + a - b - d
            || t == c - a + b + d
            || t == c - a + b - d
            || t == c - a - b + d
            || t == c - a - b - d

            || t == d + a + b - c
            || t == d + a - b + c
            || t == d + a - b - c
            || t == d - a + b + c
            || t == d - a + b - c
            || t == d - a - b + c
            || t == d - a - b - c
}

