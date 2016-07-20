package gesoft.demomockito;

import android.util.Log;

/**
 * Created by yhr on 2016/7/20.
 */

public class AccountData {

    private boolean isLogin;

    private String userName;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String log(String tag, String msg){
        System.out.println("this is "+tag);
        return "tag="+tag+", msg="+msg;
    }

    public String print( String str ){
        System.out.println( "in method print is "+str );
        return str;
    }

}
