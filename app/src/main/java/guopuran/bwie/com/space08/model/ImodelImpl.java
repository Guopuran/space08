package guopuran.bwie.com.space08.model;

import java.util.Map;

import guopuran.bwie.com.space08.util.ICallBack;
import guopuran.bwie.com.space08.util.MyCallBack;
import guopuran.bwie.com.space08.util.OkUtil;

public class ImodelImpl implements Imodel{
    @Override
    public void requestmodel(String url, Map<String, String> params, Class clazz, final MyCallBack callBack) {
        OkUtil.getInstance().getqueue(url,clazz, new ICallBack() {
            @Override
            public void success(Object object) {
                callBack.getdata(object);
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }
}
