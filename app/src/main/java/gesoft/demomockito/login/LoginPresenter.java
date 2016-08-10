package gesoft.demomockito.login;

import android.text.TextUtils;

import gesoft.demomockito.R;

/**
 * Created by yhr on 2016/7/22.
 *
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.Repository mRepository;
    LoginContract.View mView;

    public LoginPresenter( LoginContract.Repository repository, LoginContract.View view ){
        mRepository = repository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void login( String loginName, String loginPwd ) {

        if( TextUtils.isEmpty(loginName) ){
            mView.showValidError(R.string.toast_login_empty_name);
            return;
        }

        if( TextUtils.isEmpty(loginPwd) ){
            mView.showValidError(R.string.toast_login_empty_pwd);
            return;
        }

        if( loginPwd.length()<6 ){
            mView.showValidError(R.string.toast_login_length_pwd);
            return;
        }

        Bean bean = new Bean();
        Bean.Login login = bean.new Login( loginName, loginPwd );
        mRepository.send(login, new LoginContract.RepositoryCallback() {
            @Override
            public void onSend(Bean.Login login) {
                mView.onSuccess(login);
            }
        });
    }
}
