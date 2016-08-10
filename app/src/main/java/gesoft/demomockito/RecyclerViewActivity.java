package gesoft.demomockito;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import gesoft.demomockito.test.epresso.EspressoIdlingResource;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction tr = mgr.beginTransaction();
        if( mgr.findFragmentById(R.id.layout_fragment)==null ){
            tr.add( R.id.contentFrame, new RecyclerViewFragment(), RecyclerViewFragment.TAG).commit();
        }
    }

    /**
     * VisibleForTesting注解标识改方法/变量可以在单元测试中使用
     * @return
     */
    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }
}
