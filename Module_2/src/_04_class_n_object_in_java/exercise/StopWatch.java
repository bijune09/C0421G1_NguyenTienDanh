package _04_class_n_object_in_java.exercise;

import java.sql.Time;

public class StopWatch {
    private long startTime, endTime;
    public StopWatch(){
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public long start(){
        this.startTime = System.currentTimeMillis();
        return this.startTime;
    }
    public long stop(){
        this.endTime = System.currentTimeMillis();
        return this.endTime;
    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        System.out.println(stopWatch.start());
        for (int i = 0;i<10000;i++){
            System.out.println("Count in millisecond :"+i);
        }
        System.out.println(stopWatch.stop());
        System.out.println(stopWatch.getElapsedTime());
    }
}
