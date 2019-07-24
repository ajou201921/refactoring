package ac.kr.ajou.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {

    @Test
    public void login_유저아이디가_널이거나_임프티면_fail(){
        LoginService loginService= new LoginService();
        boolean result=loginService.login(null,"pwd");
        assertFalse(result);
    }

    @Test
    public void login_유저아이디가_존재하지않으면false(){
        LoginService loginService=new LoginService();
        boolean result = loginService.login("test","pwd");
        assertFalse(result);
    }
    @Test
    public void login_유저아이디가_존재하지만_패스워드틀리면false(){
        LoginService loginService=new LoginService();
        boolean result = loginService.login("test0","pwd");
        assertFalse(result);
    }
    @Test
    public void login_유저아이디가_존재하고_패스워드맞으면Ture(){
        LoginService loginService=new LoginService();
        boolean result = loginService.login("test0","test0");
        assertTrue(result);
    }
    @Test
    public void id로_유저네임을받을수있는지(){
        LoginService loginService=new LoginService();
        String playerName=loginService.getUserNameById("test0");
        assertTrue(playerName.equals("testUserName0")   );

    }
}
