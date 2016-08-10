package gesoft.demomockito.login;

/**
 * Created by Administrator on 2016/7/22.
 */

public class Bean {

    public class Login{

        public Login( String name, String pwd ){
            loginName = name;
            loginPwd = pwd;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getLoginPwd() {
            return loginPwd;
        }

        public void setLoginPwd(String loginPwd) {
            this.loginPwd = loginPwd;
        }

        private String loginName;
        private String loginPwd;
    }

}
