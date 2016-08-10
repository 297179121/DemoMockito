package gesoft.demomockito.login;

import android.content.Context;
import android.support.annotation.NonNull;

import gesoft.demomockito.login.LoginContract.*;

/**
 * Created by yhr on 2016/7/22.
 *
 */

public class LoginRepository implements Repository {

    DataSourceLocale mLocale;
    DataSourceRemote mRemote;

    public LoginRepository(Context context){
        mLocale = new DataSourceLocale(context);
        mRemote = new DataSourceRemote();
    }

    @Override
    public void send(Bean.Login login, RepositoryCallback callback) {

        callback.onSend(login);
    }

    @Override
    public void getLoginCounter(Bean.Login login, RepositoryCallback callback) {

    }

    public class DataSourceLocale{

        LoginDB mDB;

        DataSourceLocale(@NonNull Context context){
            mDB = new LoginDB(context);
        }

    }

    public class DataSourceRemote{

    }

}
