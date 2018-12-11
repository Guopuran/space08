package guopuran.bwie.com.space08.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import guopuran.bwie.com.space08.Apis;
import guopuran.bwie.com.space08.Bean;
import guopuran.bwie.com.space08.DividerDecoration;
import guopuran.bwie.com.space08.R;
import guopuran.bwie.com.space08.adapter.GridAdapter;
import guopuran.bwie.com.space08.presenter.IpresenterImpl;
import guopuran.bwie.com.space08.view.IView;

public class GridActivity extends AppCompatActivity implements IView {
    private IpresenterImpl mIpresenterImpl;
    private RecyclerView grid_view;
    //一行显示多少个
    private final int ITEM_COUNT=2;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        grid_view = findViewById(R.id.grid_view);
        mIpresenterImpl=new IpresenterImpl(this);
        mIpresenterImpl.requestter(Apis.TYPE_URL,new HashMap<String, String>(),Bean.class);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,ITEM_COUNT);
        //设置方向
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        grid_view.setLayoutManager(gridLayoutManager);
        //设置适配器
        gridAdapter = new GridAdapter(this);
        grid_view.setAdapter(gridAdapter);
        //设置增加或删除条目的动画
        grid_view.setItemAnimator(new DefaultItemAnimator());
        //自定义分割线
      /*  DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.item_grid_shu));
        DividerItemDecoration dividerItemDecoration1=new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(this,R.drawable.item_grid_heng));
        grid_view.addItemDecoration(dividerItemDecoration);
        grid_view.addItemDecoration(dividerItemDecoration1);*/
        DividerDecoration dividerDecoration=new DividerDecoration(this);
        grid_view.addItemDecoration(dividerDecoration);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIpresenterImpl.Deatch();
    }

    @Override
    public void getdata(Object object) {
        Bean bean= (Bean) object;
        final List<Bean.DataBean> data = bean.getData();
        gridAdapter.setList(bean.getData());
        gridAdapter.setCliclListener(new GridAdapter.Click() {
            @Override
            public void OnClick(int position) {
                gridAdapter.removeList(position);

            }
        });
    }
}
