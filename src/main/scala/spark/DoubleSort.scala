package spark

import org.apache.spark.SparkContext

object DoubleSort {
    def main(args: Array[String]): Unit = {
        val sc = new SparkContext("local","doublesort")
        sc.setLogLevel("ERROR")
        val rdd = sc.textFile("testfile/doublesort")
        rdd.map(a => (a.split(" ")(0),a.split(" ")(1).toInt)).groupByKey().mapValues(x => x.toSeq.sortWith(_>_))
                .mapValues(x => x.take(3))
            .foreach(println)
        println("二次排序使用sortBy")
        /**
          * 二次排序使用sortBy
          */

        rdd.map(a => (a.split(" ")(0),a.split(" ")(1).toInt)).sortBy(x=>x,false).foreach(println)

        /**
          * 二次排序使用sortBykey
          * 构建一个可以用来排序的key值
          */
        println("二次排序使用sortBykey")
        rdd.map(a => (new SortClass(a.split(" ")(0),a.split(" ")(1).toInt),a)).sortByKey()
                .map(a => a._2)
            .foreach(println)

    }

}
class SortClass(val x :String,val y:Int) extends Serializable with Ordered[SortClass]{

    override def compare(that: SortClass): Int = {
        if(!this.x.equals(that.x)){
            this.x.hashCode - that.x.hashCode
        }
        else {
            this.y - that.y
        }
    }
}


