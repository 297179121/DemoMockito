package gesoft.demomockito.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

import gesoft.demomockito.R;
import gesoft.demomockito.base.BaseFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends BaseFragment
        implements LoginContract.View, View.OnClickListener {

    EditText etUserName;
    EditText etUserPwd;
    Button btnSubmit;
    ProgressDialog mPro;
    LoginContract.Presenter mPresenter;

    public LoginActivityFragment() {
        Log.d(TAG, TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPro = new ProgressDialog(getActivity());
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUserName = (EditText)view.findViewById(R.id.et_username);
        etUserPwd = (EditText)view.findViewById(R.id.et_userpwd);
        btnSubmit = (Button)view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        return view;
    }

    @Override
    public void setLoader(boolean isShow) {
        if( isShow ){
            mPro.setMessage("正在提交...");
            mPro.show();
        }else{
            mPro.hide();
        }
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showValidError(int resId) {
        T(resId);
    }

    @Override
    public void onSuccess(Bean.Login login) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("用户名 "+login.getLoginName()+"\n密码    "+login.getLoginPwd());
        builder.create().show();
    }

    void T(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    void T(int resId){
        Toast.makeText(getActivity(), getResources().getString(resId), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        mPresenter.login( etUserName.getText().toString(), etUserPwd.getText().toString() );
    }
}
