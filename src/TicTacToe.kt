
fun main() {
    var arr = Array<Char>(9) {' '}
    printBoard(arr)
}

fun printBoard(arr: Array<Char>){
    println("   0 1 2")
    println("0 ${arr[0]}|${arr[1]}|${arr[2]} ")
    println("  -+-+-")
    println("1 ${arr[3]}|${arr[4]}|${arr[5]}")
    println("  -+-+-")
    println("2 ${arr[6]}|${arr[7]}|${arr[8]}")
}