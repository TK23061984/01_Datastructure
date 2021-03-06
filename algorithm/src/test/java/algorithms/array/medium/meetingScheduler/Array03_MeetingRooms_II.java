package algorithms.array.medium.meetingScheduler;

import java.util.*;

import org.testng.annotations.Test;

public class Array03_MeetingRooms_II {

	@Test
	private void test() {
		//int[][] intervals= {{9,10},{4,9},{4,17}};
		int[][] intervals= {{2,15},{36,45},{9,29},{16,23},{4,9}};
		System.out.println(minMeetingRooms(intervals));
	}
	
	public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int[] i:intervals){
            if(!pq.isEmpty()&&pq.peek()[1]<=i[0]){
                pq.poll();
                /****** IMPORTANT Priority Queue will not re-arrange after the value update. 
                 * so instead of poll(), if we do pq.peek()[1] that will not work
                 */
            	//pq.peek()[1] = Math.max(i[1], pq.peek()[1]);
            }else {
            	pq.add(i);
            }
        }
        return pq.size();
    }
	
	public int minMeetingRooms_2(int[][] intervals) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : intervals) {
            m.put(t[0], m.getOrDefault(t[0], 0) + 1);
            m.put(t[1], m.getOrDefault(t[1], 0) - 1);
        }
        int res = 0, cur = 0;
        for (int v : m.values()) {
            res = Math.max(res, cur += v);
        }
        return res;
    }
	
}
