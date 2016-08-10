package gesoft.demomockito.login;

/**
 * Created by Administrator on 2016/7/21.
 */

public interface LoginContract {

    interface View{
        void setLoader(boolean isShow);
        void setPresenter(Presenter presenter);
        void showValidError(int resId);
        void onSuccess(Bean.Login login);
    }

    interface Presenter{
        void login( String loginName, String loginPwd );
    }


    interface Repository{
        void send( Bean.Login login, RepositoryCallback callback );
        void getLoginCounter( Bean.Login login, RepositoryCallback callback );
    }

    interface RepositoryCallback{
        void onSend(Bean.Login login);
    }

}
