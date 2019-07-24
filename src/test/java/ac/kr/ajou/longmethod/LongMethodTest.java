package ac.kr.ajou.longmethod;

import org.junit.Test;

public class LongMethodTest {
    @Test
    public void doSomeThing_소셜스트링이_6자리가아니면에러(){
        LongMethod longMethod= new LongMethod();
        longMethod.doSomething("111111","ab","123123123");
    }
    @Test(expected = RuntimeException.class)
    public void doSomeThing_소셜스트링에_숫자가_있으면_에러(){
        LongMethod longMethod=new LongMethod();
        longMethod.doSomething("abvded","ab","123");
    }

}
