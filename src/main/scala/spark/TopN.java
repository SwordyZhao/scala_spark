package spark;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import scala.Tuple2;
import scala.tools.cmd.gen.AnyVals;


public class TopN {
    static SortedMap<Integer,String> topN(List<Tuple2<String,Integer>> L,int N){
        if(L == null || L.isEmpty()){
            return null;
        }else {
            //TreeMap 是根据key值大小排序的
            SortedMap<Integer,String> sm = new TreeMap();
            for (Tuple2<String,Integer> emement : L){

                sm.put(emement._2,emement._1);
                //当sm中的数据超出N，则删除最小的数据
                if(sm.size()>N) sm.remove(0);
            }
            return sm;
        }
    }

}
