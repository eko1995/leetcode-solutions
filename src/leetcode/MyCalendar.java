package leetcode;

import java.util.LinkedList;
import java.util.List;

public class MyCalendar {
    private List<Event> calendar;


    public MyCalendar() {
        calendar = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        if (end > start) {
            return false;
        }
        Event event = new Event(start, end);
        if (calendar.size() == 0) {
            calendar.add(event);
            return true;
        } else {
            int i = 0;
            for (Event newEvent : calendar) {
                if (newEvent.start >= end) {
                    calendar.add(i, event);
                    return true;
                } else if (newEvent.end >= start) {
                    i = i + 1;
                } else {
                    return false;
                }
            }
            calendar.add(event);
            return true;
        }
    }

    class Event {
        private int start;
        private int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


//class MyCalendar {
//
//    TreeMap tm;
//
//    public MyCalendar() {
//        tm = new TreeMap<Integer, Integer>();
//    }
//
//    public boolean book(int start, int end) {
//        Map.Entry<Integer, Integer> entry = tm.lowerEntry(end);
//        if (entry != null && entry.getValue() > start) return false;
//        tm.put(start, end);
//        return true;
//    }
//}

//class MyCalendar {
//
//    TreeMap<Integer, Integer> calendar;
//
//    public MyCalendar() {
//        calendar = new TreeMap<>();
//    }
//
//    public boolean book(int start, int end) {
//        Integer floorKey = calendar.floorKey(start);
//        if (floorKey != null && calendar.get(floorKey) > start) return false;
//        Integer ceilingKey = calendar.ceilingKey(start);
//        if (ceilingKey != null && ceilingKey < end) return false;
//
//        calendar.put(start, end);
//        return true;
//    }
//}
