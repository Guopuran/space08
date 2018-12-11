package guopuran.bwie.com.space08.presenter;

import java.util.Map;

import guopuran.bwie.com.space08.model.ImodelImpl;
import guopuran.bwie.com.space08.util.MyCallBack;
import guopuran.bwie.com.space08.view.IView;

public class IpresenterImpl implements Ipresenter {
    private ImodelImpl mImodelImpl;
    private IView mIView;

    public IpresenterImpl(IView mIView) {
        this.mIView = mIView;
        mImodelImpl=new ImodelImpl();
    }
    //解绑
    public void Deatch(){
        if (mImodelImpl!=null){
            mImodelImpl=null;
        }
        if (mIView!=null){
            mIView=null;
        }
    }
    @Override
    public void requestter(String url, Map<String, String> params, Class clazz) {
        mImodelImpl.requestmodel(url, params, clazz, new MyCallBack() {
            @Override
            public void getdata(Object object) {
                mIView.getdata(object);
            }
        });
    }
}
