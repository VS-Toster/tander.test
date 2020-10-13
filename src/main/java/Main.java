import service.MainService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Start program " + start);
        MainService mainService = new MainService();
        mainService.start(1000000);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Start program " + end);
        System.out.println("Time (minutes) of working is " + ChronoUnit.MINUTES.between(start, end));
    }
}


