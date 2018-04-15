package scala

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Test1 {
    def main(args: Array[String]): Unit = {
        test3(25,7)
    }
    def test1: Unit ={
        val a = "121"
        val b = a.split("2")(1)

        println(b)
        println(a+1)
    }

    def test2: Unit ={
        val a = 1.to(10)
        //a.sortBy
    }
    def test3(m:Int,n:Int): Unit ={
        var listM = new ListBuffer[Int];
        //val ele1 = 0
        //listM.append()
        //System.exit(-1)
        for(ele1 <- 1.to(m)){
            listM.append(ele1)
        }
//System.exit(-1)
        var i = 0;
        var j = 1;
        var k = listM.size
        while(listM.size != 1){
            if(j == n){
                println(listM(i))
                listM.remove(i);
                j = 1;
                i-=1
            }else{
                j+=1;
            }
            i+=1;
            if(i >= listM.size){
                i = 0;
            }
        }

        println(listM(0)+"&&&");
    }
    def test4: Unit ={

    }




}
