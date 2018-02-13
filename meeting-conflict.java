import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Meeting {
    
    // Parameters
    String room;
    Calendar start = Calendar.getInstance();
    Calendar end = Calendar.getInstance();

    // Meeting constructor
    public Meeting(Calendar startDate, Calendar endDate, String meetingRoom) {
        room = meetingRoom;
        start = startDate;
        end = endDate;
    }
    
    // true = conflict & false = no conflict
    public static boolean meetingConflict(Meeting a, Meeting b) {
        
        if (a.start.equals(b.start) && a.end.equals(b.end) && a.room == b.room) {
            return true;
        } else if (a.end.after(b.start) && a.end.before(b.end) && a.room == b.room) {
            return true;
        } else if (a.start.after(b.start) && a.start.before(b.end) && a.room == b.room) {
            return true;
        } else if (a.start.after(b.start) && a.end.before(b.end) && a.room == b.room) {
            return true;
        } else if (a.start.before(b.start) && a.end.after(b.end) && a.room == b.room) {
            return true;
        } else {
            return false;
        }
  
    }

    public static void main(String args[]) {
        
        // Date formatter
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        
        // Meeting A 
        Calendar aStart = Calendar.getInstance();
        aStart.set(2018,02,14,14,00,00);
        Calendar aEnd = Calendar.getInstance();
        aEnd.set(2018,02,14,14,59,59);
        Meeting a = new Meeting(aStart, aEnd, "Grand");
        System.out.println("### Meeting A ###");
        System.out.println("Room: " + a.room);
        System.out.println("Start Time: " + dateFormatter.format(a.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(a.end.getTime()));
        System.out.println("");
    
        /*
        // Meeting B starts before Meeting A Ends
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,14,30,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,15,29,59);
        Meeting b = new Meeting(bStart, bEnd, "Grand");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        */
        
        /*
        // Meeting A starts before Meeting B Ends
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,13,30,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,14,29,59);
        Meeting b = new Meeting(bStart, bEnd, "Grand");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        */
        
         /*
        // Meeting A start and ends the same time as B
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,14,00,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,14,59,59);
        Meeting b = new Meeting(bStart, bEnd, "Grand");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        */
        
        /*
        // Meeting A falls within Meeting B
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,12,00,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,15,59,59);
        Meeting b = new Meeting(bStart, bEnd, "Grand");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        */
        
        /*
        // Meeting B falls within Meeting A
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,14,15,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,14,29,59);
        Meeting b = new Meeting(bStart, bEnd, "Grand");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        */
        
        /*
        // No conflict same room
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,10,00,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,10,59,59);
        Meeting b = new Meeting(bStart, bEnd, "Grand");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        */
        
        
        // No conflict different room
        Calendar bStart = Calendar.getInstance();
        bStart.set(2018,02,14,14,00,00);
        Calendar bEnd = Calendar.getInstance();
        bEnd.set(2018,02,14,14,59,59);
        Meeting b = new Meeting(bStart, bEnd, "Hill");
        System.out.println("### Meeting B ###");
        System.out.println("Room: " + b.room);
        System.out.println("Start Time: " + dateFormatter.format(b.start.getTime()));
        System.out.println("End Time: " + dateFormatter.format(b.end.getTime()));
        System.out.println("");
        
        
        // Check for conflict
        boolean isConflict = meetingConflict(a, b);
        System.out.println("### Conflict ###");
        System.out.println(isConflict);

    }

}
