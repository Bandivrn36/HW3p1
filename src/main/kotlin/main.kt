const val userOnline:String = "Был(а) в сети "
const val back:String = " назад."

fun main(){
    val timeAgoSeconds: Int = 82800

    agoToText(timeAgoSeconds)


}
fun agoToText(time: Int) {
    when{
        time <= 60 -> justNow()
        time in 61..120 -> oneMinute()
        time in 121..3_600 -> minutes(time)
        time in 3601..86_400 -> hours(time)
        time in 86_401..172_800 -> println("$userOnline сегодня")
        time in 172_801..259_200 -> println("$userOnline вчера")
        else -> println("$userOnline давно")
    }
}



fun justNow(){
    println("$userOnline только что.")
}
fun oneMinute(){
    println("$userOnline 1 минуту $back")
}
fun minutes(time: Int){
    val inMinutes:Int = toMinutes(time)
    when{
        time / 60 >= 5 && time /60 < 20 -> println("$userOnline $inMinutes минут $back")
        time / 60 % 10 == 1 -> println("$userOnline $inMinutes минуту $back")
        time / 60 % 10 == 5 -> println("$userOnline $inMinutes минут $back")
        else -> println("$userOnline $inMinutes минуты $back")


    }


}
fun hours(time: Int){
    val inHours:Int = toHours(time)
    when (inHours) {
        1, 21 -> println("$userOnline $inHours час $back")
        in 5..20 -> println("$userOnline $inHours часов $back")
        else -> println("$userOnline $inHours часа $back")
    }
}

fun toMinutes(time: Int):Int {
    return time/60
}
fun toHours(time: Int):Int{
    return time / 60 / 60
}
