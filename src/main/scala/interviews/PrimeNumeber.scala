package interviews

import scala.collection.mutable.ListBuffer
import util.control.Breaks._

object PrimeNumeber {
    def main(args: Array[String]): Unit = {
        println(test2)
    }

    //100以内的质数
    def test: List[Int] = {
        var list = ListBuffer[Int]()
        list.append(2)
        for (i <- 3 to 100) {
            val num = i
            breakable {
                for (j <- 2 to num - 1) {
                    if (num % j == 0) break
                }
                list.append(i)
            }

        }
        val ll = list.toList
        ll
    }

    //三角9*9
    def test2: Unit = {
        for (i <- (1 to 9).reverse) {
            for (j <- (1 to i).reverse) {
                print(i * j + "\t")
            }
            println()
        }
    }

}


















