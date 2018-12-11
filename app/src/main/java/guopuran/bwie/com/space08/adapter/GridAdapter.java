package guopuran.bwie.com.space08.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import guopuran.bwie.com.space08.Bean;
import guopuran.bwie.com.space08.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<Bean.DataBean> list;
    private Context context;

    public GridAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<Bean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public Bean.DataBean getitem(int position){
        return list.get(position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getdata(getitem(i),context,i);
    }
    //删除数据
    public void removeList(int position){
        list.remove(position);
        //必须使用notifyItemRemoved 才能加载移除动画
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position,list.size());

    }
    //添加数据
    public void additem(int position, Bean.DataBean bean){
        list.add(position,bean);
        notifyItemInserted(position);
    }
    static Click mClick;
    public void setCliclListener(Click click){
        mClick=click;
    }
    public interface Click{
        void OnClick(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.grid_text);
            imageView=itemView.findViewById(R.id.grid_image);
        }

        public void getdata(Bean.DataBean getitem, Context context, final int i) {
            textView.setText(getitem.getName());
            Glide.with(context).load(getitem.getIcon()).into(imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClick.OnClick(i);
                }
            });
        }
    }
}
