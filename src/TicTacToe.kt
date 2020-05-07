
fun main() {
    var arr = Array<Char>(9) {' '}
    printBoard(arr)
}

fun printBoard(arr: Array<Char>){
    println("  0 1 2")
    for(i in 0..2){
        println("$i ${arr[3 * i]}|${arr[3 * i + 1]}|${arr[3 * i + 2]} ")
        if(i < 2) println("  -+-+-")
    }
}