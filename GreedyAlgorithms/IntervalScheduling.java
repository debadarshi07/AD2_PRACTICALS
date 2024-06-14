package GreedyAlgorithms;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start,end;
	Interval(int start,int end) {
		this.start=start;
		this.end=end;
	}
}

public class IntervalScheduling {
	public static void listSchedules(List<Interval> intervals) {
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(3,6));
		intervals.add(new Interval(5,7));
		intervals.add(new Interval(8,10));
	}
	
	public static List<Interval> scheduleInterval(List<Interval> intervals){
		Collections.sort(intervals,Comparator.comparingInt(i->i.end));
		List<Interval> result =new ArrayList<>();
		if(intervals.isEmpty()) return result;
		Interval lastInterval=intervals.get(0);
		result.add(lastInterval);
		for(int i=0;i<intervals.size();i++) {
			Interval currentInterval=intervals.get(i);
			if(currentInterval.start>=lastInterval.end) {
				result.add(currentInterval);
				lastInterval=currentInterval;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		List<Interval> intervals=new ArrayList<>();
		listSchedules(intervals);
		
		List<Interval> result=scheduleInterval(intervals);
		
		System.out.println("Maximal set of mutual compatible intervals: ");
		for(Interval interval:result) {
			System.out.println("["+interval.start+","+interval.end+"]");
		}
	}
}
