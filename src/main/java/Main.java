import service.MainService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toString());
        MainService mainService = new MainService();
        mainService.start(1000000);
        System.out.println(LocalDateTime.now().toString());
    }
}


