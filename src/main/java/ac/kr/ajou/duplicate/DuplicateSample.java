package ac.kr.ajou.duplicate;

public class DuplicateSample {

    public int calc(EventData ed) {
        if (ed.getPrice() > 10) {
            logPriceAndName(ed);
            return 1;
        }
        if (ed.getEventName().equals("test")) {
            logPriceAndName(ed);
            return 2;
        }


        return 0;
    }

    private void logPriceAndName(EventData ed) {
        System.out.println(ed.getPrice());
        System.out.println(ed.getEventName());
    }
}
