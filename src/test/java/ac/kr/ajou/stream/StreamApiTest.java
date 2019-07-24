package ac.kr.ajou.stream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StreamApiTest {

    @Test
    public void filterString_제대로_필터된_스트링을_반환(){
        StreamApi streamApi = new StreamApi();
        List<String> testStringList = new ArrayList<>();
        testStringList.add("abc");
        testStringList.add("a22");
        testStringList.add("a4");
        testStringList.add("55");
        testStringList.add("55");

        List<String> result = streamApi.filterString(testStringList, "55");
        assertTrue(result.size() == 2);
        assertTrue(result.get(0).equals("55"));
        assertTrue(result.get(1).equals("55"));
    }
}
