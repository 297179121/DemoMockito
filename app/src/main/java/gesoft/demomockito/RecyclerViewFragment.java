package gesoft.demomockito;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import gesoft.gapp.common.GRAdapter;
import gesoft.gapp.common.GRAdapterListener;
import gesoft.gapp.common.GVHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements GRAdapterListener.OnConvert<String> {


    @Bind(R.id.recycler)
    RecyclerView recycler;

    public final static String TAG = RecyclerViewFragment.class.getName();

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        List<String> listStr = Arrays.asList(getArray(20));

        ButterKnife.bind(this, view);
        GRAdapter adapter = new GRAdapter(android.R.layout.simple_list_item_1);
        adapter.setOnConvertListener(this);
        adapter.addAll(listStr);
        recycler.setAdapter(adapter);

        return view;
    }

    private String[] getArray(int count){
        String[] array = new String[count];
        for( int i=0; i<count; i++ ){
            array[i] = "第"+i+"个";
        }
        return array;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onConvert(GVHolder gvHolder, String s) {
        gvHolder.setText(android.R.id.text1, s);
    }
}
