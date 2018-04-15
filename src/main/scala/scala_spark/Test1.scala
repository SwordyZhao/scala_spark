package scala_spark

import org.apache.spark.SparkContext
import org.apache.log4j.{Logger, Level}

object Test1 {
    //减少任务日志输出
    //Logger.getLogger("org").setLevel(Level.ERROR)

    def main(args: Array[String]): Unit = {
        SparkContext
        val sc = new SparkContext("local", "SparkTest")
        sc.setLogLevel("ERROR")

        val rdd = sc.textFile("testfile/doublesort")
        rdd.flatMap(x => x.split(" ")).map(word => (word, 1)).
            reduceByKey((x, y) => x + y).foreach(println)


    }

}
