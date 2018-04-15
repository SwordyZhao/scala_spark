package spark

import org.apache.spark.SparkContext

import scala.collection.SortedMap
import scala.collection.immutable.TreeMap

object TopNTest {
    /**
      * topN模式
      * 若数据量小：则可以
      * 两个思路，首先是根据key值直接取前n
      * 其次是先用groupByKey聚合一下，然后用take取topN，然后再拆开
      * 若数据量大，则需要：
      * 构建一个sortedMap sm，将数据挨个添加到sm，若sm.size>n，则移除第一个元素
      * @param args
      */
    def main(args: Array[String]): Unit = {

        val sc = new SparkContext("","")
        val lines = sc.textFile("")
        val pairRDD = lines.map(a =>(a.split(" ")(1).toInt,a.split(" ")(0)))
        val setRDD = pairRDD.mapPartitions(
            sortedMap
        )
            //方法2，取排序取前10
            //.sortBy(x=>x._1).take(10)

        //方法1，将rdd转化成list，然后取前10个元素
        val fail = pairRDD.collect()
        var fm = new TreeMap[Int,String]()
        for(a <- fail){
            fm+=a
            if(fm.size>10){
                fm.-(0)
            }
        }

    }

    def sortedMap(iterator: Iterator[(Int,String)]): Iterator[(Int,String)] ={
        var sm = new TreeMap[Int,String]()
        while(iterator.hasNext){
            sm+=(iterator.next()._1 -> iterator.next()._2)
            if(sm.size>10) sm.-(0)
        }
        sm.toIterator

    }

//scala实现排序方法
    def scalaMenond(list: List[Tuple2[String,Int]],a:Int): SortedMap[String,Int] ={
        if(list == null || list.isEmpty) null
        else{
            val sm:SortedMap[String,Int] = new TreeMap[String,Int]

            sm
        }

    }

}
