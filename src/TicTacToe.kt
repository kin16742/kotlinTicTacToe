
fun main() {
    var arr = Array<Char>(9) {'O'}

    initBoard(' ') {initChar -> arr = Array<Char>(9) {initChar} }
    play(arr)
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

fun isValid(x: List<Int>, arr: Array<Char>, c: Char): Boolean{
    return arr[x[0]*3 + x[1]] == ' ' && arr[x[0]*3 + x[1]] != c
}

fun playerInput(playerId: Int): List<Int>{
    print("Player $playerId 입력 : ")
    val str: String = readLine()!!.toString()
    return str.split(", ").map { it.toInt() }
}

fun isWin(arr: Array<Char>, c: Char): Boolean{
    return winCheck(arr,c,0,1,2) || winCheck(arr,c,3,4,5) || winCheck(arr,c,6,7,8) ||
            winCheck(arr,c,0,3,6) || winCheck(arr,c,1,4,7)|| winCheck(arr,c,2,5,8)||
            winCheck(arr,c,0,4,8)|| winCheck(arr,c,2,4,6)
}

fun winCheck(arr: Array<Char>, c: Char, vararg a: Int): Boolean{
    for(i in a)
        if(arr[i] != c) return false
    return true
}

fun play(arr: Array<Char>){
    while(true) {
        printBoard(arr)
        if(isWin(arr,'X')) {
            println("Player 2 Win!")
            break
        }
        while (true) {
            val point = playerInput(1)
            if (isInRange(point) && isValid(point, arr, 'X')) {
                arr[point[0] * 3 + point[1]] = 'O'
                break;
            }
        }
        printBoard(arr)
        if(isWin(arr,'O')) {
            println("Player 1 Win!")
            break
        }
        while (true) {
            val point = playerInput(2)
            if (isInRange(point) && isValid(point, arr, 'O')) {
                arr[point[0] * 3 + point[1]] = 'X'
                break;
            }
        }
    }
}