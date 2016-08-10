package gesoft.demomockito;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import gesoft.demomockito.login.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


/**
 * Created by yhr on 2016/7/22.
 * Espresso实例
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void switchToLogin () {
        //loginActivity = mActivityRule.getActivity();
    }


    @Test
    public void display(){
        //id为et_username的元素必须可见
        onView(withId(R.id.et_username)).check(matches(isDisplayed()));
        //id为et_userpwd的元素必须可见
        onView(withId(R.id.et_userpwd)).check(matches(isDisplayed()));
        //在view中显示，但是超出屏幕
        //onView(withId(R.id.et_username)).check(matches(not(isDisplayed())));
    }

    @Test
    public void valid(){

        View view = mActivityRule.getActivity().getWindow().getDecorView();

        //设置id为et_username的元素中text值为空白
        onView(withId(R.id.et_username)).perform(typeText(""));
        //id为btn_submit的元素执行单击操作
        onView(withId(R.id.btn_submit)).perform(click());

        matchToast( R.string.toast_login_empty_name, view );

        //设置id为et_username的元素中text值为yhr,并关闭键盘
        onView(withId(R.id.et_username)).perform(typeText("yhr"), closeSoftKeyboard());
        sleep(2000);

        //userpwd非空校验
        onView(withId(R.id.et_userpwd)).perform(typeText(""));
        onView(withId(R.id.btn_submit)).perform(click());
        matchToast( R.string.toast_login_empty_pwd, view );
        sleep(2000);

        //userpwd长度校验
        onView(withId(R.id.et_userpwd)).perform(typeText("pwd"), closeSoftKeyboard());
        onView(withId(R.id.btn_submit)).perform(click());
        matchToast( R.string.toast_login_length_pwd, view );

    }

    @Test
    public void login(){

    }

    /**
     * 匹配Toast
     * @param resId string资源
     * @param view
     */
    void matchToast( int resId, View view ){
        onView(withText(resId)).inRoot(withDecorView(not(is(view)))).check(matches(isDisplayed()));
    }

    /**
     * 休眠
     * @param s 休眠时间
     */
    static void sleep(long s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            Log.e("tag", "msg", e);
        }
    }

}
