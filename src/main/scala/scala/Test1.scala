package scala

import org.junit.Test

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.Random

object Test1 {
    def main(args: Array[String]): Unit = {
        //println(charProd2("zhaogs"))
        //println(charProd("zhaogs"))
        //nArray(8)
        //releaseArray2
        countDown(10)
    }

    def test1: Unit = {
        val a = "121"
        val b = a.split("2")(1)

        println(b)
        println(a + 1)
    }

    def test2: Unit = {
        val a = 1.to(10)
        //a.sortBy
    }

    def test3(m: Int, n: Int): Unit = {
        var listM = new ListBuffer[Int];
        //val ele1 = 0
        //listM.append()
        //System.exit(-1)
        for (ele1 <- 1.to(m)) {
            listM.append(ele1)
        }
        //System.exit(-1)
        var i = 0;
        var j = 1;
        var k = listM.size
        while (listM.size != 1) {
            if (j == n) {
                println(listM(i))
                listM.remove(i);
                j = 1;
                i -= 1
            } else {
                j += 1;
            }
            i += 1;
            if (i >= listM.size) {
                i = 0;
            }
        }

        println(listM(0) + "&&&");
    }

    def test4: Unit = {

    }

    def sinNum(num: Int): Int = {
        if (num > 0) 1
        else {
            if (num < 0) -1
            else 0
        }
    }

    def charProd(word: String): Long = {
        var prod: Long = 1
        if (word.size == 0) 0
        for (i <- 0 until word.size) {
            prod *= word.charAt(i)
        }
        prod
    }

    def charProd2(word: String): Long = {
        println(word.size)
        if (word.size == 0) 0
        if (word.size == 1) word.charAt(0)
        else {
            println(word.charAt(word.size - 1))
            charProd2(word.substring(1)) * word.charAt(0)
        }
    }

    //生成一个长度为n的随机数组
    @Test
    def nArray(n: Int): Unit = {
        var a = ArrayBuffer[Int]()
        for (i <- 0 until n) {
            a +=
                Random.nextInt(n)
        }
        println(a.toList)
    }

    @Test
    //将相邻的数字互换
    def releaseArray: Unit = {
        val n = 7
        val a = ArrayBuffer[Int]()
        for (i <- 0 until n) {
            a += Random.nextInt(n)
        }
        println(a)
        for (i <- 0 until n - 1) yield {
            if (i % 2 == 0 && a(i + 1) != null) {
                val elem1 = a.apply(i)

                a.remove(i)

                a.insert(i + 1, elem1)
                println(a)
                //                System.exit(-1)

            }
        }

    }

    //将相邻的数字互换
    def releaseArray2: Unit = {
        val n = 7
        val a = ArrayBuffer[Int]()
        for (i <- 0 until n) {
            a += Random.nextInt(n)
        }
        println(a)
        val c = for (i <- 0 until n ) yield {
            if (a.length % 2 == 1 && i == a.length - 1) a(i)
            else {
                if (i % 2 == 0) a(i + 1)
                else (a(i - 1))
            }

        }
        println(c)
        //println(c)
    }
    //打印数字n到0
    def countDown(n: Int): Unit ={
        for(i <- (0 to n).reverse) println(i)
    }

    //计算字符乘积


}
