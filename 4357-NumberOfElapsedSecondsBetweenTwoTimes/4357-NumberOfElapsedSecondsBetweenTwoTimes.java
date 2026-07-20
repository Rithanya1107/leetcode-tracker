// Last updated: 7/20/2026, 10:16:47 AM
class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start = convertToSeconds(startTime);
        int end = convertToSeconds(endTime);

        return end - start;
    }

    private int convertToSeconds(String time){
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int seconds = Integer.parseInt(time.substring(6, 8));

        return hours * 3600 + minutes * 60 + seconds;
    }
}