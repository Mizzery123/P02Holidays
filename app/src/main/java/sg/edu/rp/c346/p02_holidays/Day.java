package sg.edu.rp.c346.p02_holidays;

public class Day {
    private String name;
    private String date;
    private boolean day;
    private String type;
    public Day(String name, String date, boolean day, String type) {
        this.name = name;
        this.date = date;
        this.day = day;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public String getDate(){
        return date;
    }
    public boolean isDay() {
        return day;
    }
    public String getType(){
        return type;
    }
}
