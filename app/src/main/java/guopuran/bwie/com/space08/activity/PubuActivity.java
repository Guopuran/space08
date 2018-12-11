package guopuran.bwie.com.space08.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.HashMap;

import guopuran.bwie.com.space08.Apis;
import guopuran.bwie.com.space08.Bean;
import guopuran.bwie.com.space08.DividerDecoration;
import guopuran.bwie.com.space08.R;
import guopuran.bwie.com.space08.adapter.StaggAdapter;
import guopuran.bwie.com.space08.presenter.IpresenterImpl;
import guopuran.bwie.com.space08.view.IView;

public class PubuActivity extends AppCompatActivity implements IView {
    private IpresenterImpl mIpresenterImpl;
    private RecyclerView pubu_view;
    private final int ITEM_COUNT=2;
    private StaggAdapter staggAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubu);
        //获取资源ID
        pubu_view = findViewById(R.id.pubu_view);
        mIpresenterImpl=new IpresenterImpl(this);
        mIpresenterImpl.requestter(Apis.TYPE_URL,new HashMap<String, String>(),Bean.class);
        //获得布局管理器
        //使用瀑布流布局,第一个参数 spanCount 一行几个,第二个参数 orentation 排列方向
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(ITEM_COUNT,OrientationHelper.VERTICAL);
        pubu_view.setLayoutManager(manager);
        staggAdapter = new StaggAdapter(this);
        pubu_view.setAdapter(staggAdapter);
        //自定义分割线
        DividerDecoration dividerDecoration=new DividerDecoration(this);
        pubu_view.addItemDecoration(dividerDecoration);
    }
    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIpresenterImpl.Deatch();
    }

    @Override
    public void getdata(Object object) {
        Bean bean= (Bean) object;
        staggAdapter.setList(bean.getData());
    }
}
