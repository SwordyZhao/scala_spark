package java_test;

import scala.Int;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Algorithm_Test1 {
    //用于格式化时间的显示形式，以及将string类型的时间转化成date格式
    private SimpleDateFormat dd = null;

    public Object getDD(){
        return  dd.clone();
    }
    public void setDD(int y, int m, int d){
        dd = new SimpleDateFormat("20170113");
    }
    public static void main(String[] args) {
        test1(25,7);
    }
    private static void test1(int m, int n){
        LinkedList<Integer> listM = new LinkedList<Integer>();

        for(int i = 0; i<m; i++){
            listM.add(i+1);
        }

        int i = 0;
        int j = 0;
        while(listM.size()==1){
            if(j == n){
                listM.remove(i);
                j = 0;
            }
            j++;
            i++;
            if(i == listM.size()){
                i = 0;
            }
        }
        System.out.println(listM.get(0));
    }

}

class Test11{
    public static void main(String[] args) {
        Algorithm_Test1 at1 = new Algorithm_Test1();
        at1.setDD(2017,12,23);
        SimpleDateFormat mm = (SimpleDateFormat) at1.getDD();

        System.out.println(mm);
        //System.out.println((Date)at1.getDD());

    }
}
