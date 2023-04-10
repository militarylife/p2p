package cn.itcast.wanxinp2p.account.controller;

import java.util.ArrayList;
import java.util.List;

public class abcd {
    public static void main(String[] args) {
        List<String> ss=createCron(40);
        System.out.println(ss);
    }

    //periodTime 间隔时间 单位：分钟
    //返回列表形式的String类型数据，将每一条cron表达式作为列表中的一项
    public static List<String> createCron(Integer periodTime){
        List<String> cronList=new ArrayList<>();
        String cronStr = "* * * * * ?";

        int extraMin;
        //间隔时间大于1小时且不超过1天的情况
        if (periodTime>=60&&periodTime<=(60*24)){
            //间隔多少小时hour，以及额外多少分钟minutes
            int hours=periodTime/60;
            int minutes=periodTime%60;
            if(hours>24||minutes>60){
                System.out.println("间隔时间超过1天");
                cronList.add(cronStr);
                return cronList;
            }
            if(minutes==0){
                //cron="0 0 0/2 * * ?"      从0小时开始，每2小时执行一次
                cronStr="0 0 0/"+(periodTime/60)+" * * ?";
                cronList.add(cronStr);
                return cronList;
            }
            else{
                //开始
                int n=2;
                //当间隔时间大于半天，一天无法执行2次
                if((periodTime*n)>(24*60)){
                    int phours=periodTime/60;
                    int pMins=periodTime%60;
                    //cron="0 30 12 * * ?"  每天的12点半执行
                    cronStr="0 "+pMins+" "+phours+" * * ?";
                    cronList.add(cronStr);
                    return cronList;
                }
                //找到倍数
                while((periodTime*n-periodTime)%60!=0&&((periodTime*n)<=(24*60))){
                    System.out.println("间隔时间为:"+(periodTime*n));
                    n++;
                }
                System.out.println("倍数为："+n+" 目标时间分钟数为:"+(n*periodTime));
                //周期时间，每个相邻时间点的间隔分钟为periodTime，每个cron的周期时间为cycleTime
                int cycleTime=(n-1)*periodTime;
                //确定周期
                for(int i=1;i<n;i++){
                    //1个半小时
                    // "0 30 1/3 * * ?"     1:30,4:30,7:30..
                    // "0 0 0/3 * * ?"      0:00,3:00,6:00..
                    int itemHour=(periodTime*i)/60;
                    int itemMins=(periodTime*i)%60;
                    if((itemHour-(cycleTime/60))==0)itemHour=0;     //确保从0点开始
                    String cronItem="0 "+itemMins+" "+itemHour+"/"+(cycleTime/60)+" * * ?";
                    System.out.println("item的cron表达式是:"+cronItem);
                    cronList.add(cronItem);
                }
                return cronList;
            }

        }
        //间隔小于1小时情况（这部分代码不完整，需要自行仿照上面的小时判断改写，这里只是单纯的在每小时内保持了执行周期）
        if(periodTime<60&&periodTime>0)
        {
            //cron="0 0/1 * * * ?"      从0分钟开始，每1分钟执行一次
            cronStr="0 0/"+periodTime+" * * * ?";
            cronList.add(cronStr);
            return cronList;
        }

        cronList.add(cronStr);
        return cronList;
    }
}
