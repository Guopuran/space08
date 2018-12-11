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

public class StaggAdapter extends RecyclerView.Adapter<StaggAdapter.ViewHolder> {
    private List<Bean.DataBean> list;
    private Context context;

    public StaggAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }
    public Bean.DataBean getitem(int position){
        return list.get(position);
    }
    public void setList(List<Bean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pubu, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getdata(getitem(i),context);
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
            textView=itemView.findViewById(R.id.pubu_text);
            imageView=itemView.findViewById(R.id.pubu_image);
        }

        public void getdata(Bean.DataBean getitem, Context context) {
            textView.setText(getitem.getName());
            Glide.with(context).load(getitem.getIcon()).into(imageView);
        }
    }
}
