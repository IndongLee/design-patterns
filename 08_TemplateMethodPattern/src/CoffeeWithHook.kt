import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class CoffeeWithHook : CaffeineBeverageWithHook() {
    override fun brew() {
        println("필터로 커피를 우려내는 중")
    }

    override fun addCondiments() {
        println("우유와 설탕을 추가하는 중")
    }

    override fun customerWantsCondiments(): Boolean {
        return getUserInput().toLowerCase().startsWith('y')
    }

    private fun getUserInput(): String {
        println("커피에 우유와 설탕을 넣어 드릴까요? (y/n)")
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        return try {
            bufferedReader.readLine()
        } catch (ioe: IOException) {
            error("IO 오류")
            null
        } ?: "no"
    }
}