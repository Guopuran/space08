package guopuran.bwie.com.space08.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;

import guopuran.bwie.com.space08.Apis;
import guopuran.bwie.com.space08.Bean;
import guopuran.bwie.com.space08.R;
import guopuran.bwie.com.space08.adapter.LinearAdapter;
import guopuran.bwie.com.space08.presenter.IpresenterImpl;
import guopuran.bwie.com.space08.view.IView;

public class LinearActivity extends AppCompatActivity implements IView {

    private IpresenterImpl mIpresenterImpl;
    private RecyclerView linear_view;
    private LinearAdapter linearAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        //获取资源ID
        linear_view = findViewById(R.id.linear_view);
        //互绑
        mIpresenterImpl=new IpresenterImpl(this);
        mIpresenterImpl.requestter(Apis.TYPE_URL,new HashMap<String, String>(),Bean.class);
        //写一个布局管理器，线性管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置方向
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        linear_view.setLayoutManager(layoutManager);
        linearAdapter = new LinearAdapter(this);
        linear_view.setAdapter(linearAdapter);
        //设置分割线
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.item_decoration));
        linear_view.addItemDecoration(dividerItemDecoration);

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
        linearAdapter.setList(bean.getData());
    }
}
