
fun main() {
    var arr = Array<Char>(9) {'O'}

    playerInput(1)
    initBoard(' ') {initChar -> arr = Array<Char>(9) {initChar} }
    printBoard(arr)
}

fun printBoard(arr: Array<Char>){
    println("  0 1 2")
    for(i in 0..2){
        println("$i ${arr[3 * i]}|${arr[3 * i + 1]}|${arr[3 * i + 2]} ")
        if(i < 2) println("  -+-+-")
    }
}

fun initBoard(initChar: Char, init: (Char) -> Unit){
    init(initChar)
}

fun isInRange(x: List<Int>): Boolean{
    return x[0] in 0..2 && x[1] in 0..2
}


fun playerInput(playerId: Int){
    print("Player $playerId 입력 : ")
    val str: String = readLine()!!.toString()
    val num = str.split(", ").map { it.toInt() }
}