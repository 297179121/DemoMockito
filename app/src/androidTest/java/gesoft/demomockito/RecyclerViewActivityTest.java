package gesoft.demomockito;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import gesoft.demomockito.test.epresso.TestUtil;
import gesoft.demomockito.test.matcher.RecyclerViewMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by yhr on 2016/8/9.
 * 单元测试RecyclerView
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewActivityTest {

    final static String LAST_ITEM_TEXT = "第19个";
    final static int LAST_ITEM_POSITION = 19;

    @Rule
    public IntentsTestRule<RecyclerViewActivity> mActivityRule = new IntentsTestRule<>(RecyclerViewActivity.class);

    /**
     * 注册IdlingResource，实现异步结束后继续执行Espresso测试
     */
    @Before
    public void registerIdlingResource () {
        Espresso.registerIdlingResources( mActivityRule.getActivity().getCountingIdlingResource() );
    }

    /**
     * 要求id为R.id.recycler的组件必须显示
     */
    @Test
    public void display(){
        onView(withId(R.id.recycler)).check(matches(isDisplayed()));
    }

    /**
     * 测试RecyclerView滚动到指定Row
     */
    @Test
    public void scroll(){
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.scrollToPosition(19));
        TestUtil.sleep(5000);
    }

    /**
     * 匹配RecyclerView的Item中id为text1的组件文字
     */
    @Test
    public void matcherItemText(){
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.scrollToPosition(19));
        onView( new RecyclerViewMatcher(R.id.recycler)
                .atPositionOnView(LAST_ITEM_POSITION, android.R.id.text1))
                .check(matches(withText(LAST_ITEM_TEXT)));
    }

    /**
     * 要求id为R.id.recycler的组件必须不在当前View中
     */
    @Ignore
    @Test
    public void notExist(){
        onView(withId(R.id.recycler)).check( doesNotExist() );
    }

    /**
     * 在view中显示，但是超出屏幕
     */
    @Ignore
    @Test
    public void beyondScreen(){
        onView(withId(R.id.recycler)).check(matches(not(isDisplayed())));
    }

    /**
     * 解除IdlingResource
     */
    @After
    public void unregisterIdlingResource() {
        Espresso.unregisterIdlingResources( mActivityRule.getActivity().getCountingIdlingResource() );
    }

}