package guopuran.bwie.com.space08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Map;

import guopuran.bwie.com.space08.activity.GridActivity;
import guopuran.bwie.com.space08.activity.LinearActivity;
import guopuran.bwie.com.space08.activity.PubuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button linear;
    private Button grid;
    private Button pubu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        linear = findViewById(R.id.linear);
        grid = findViewById(R.id.grid);
        pubu = findViewById(R.id.pubu);
        linear.setOnClickListener(this);
        grid.setOnClickListener(this);
        pubu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.linear:
                startActivity(new Intent(MainActivity.this,LinearActivity.class));
                break;
            case R.id.grid:
                startActivity(new Intent(MainActivity.this,GridActivity.class));
                break;
            case R.id.pubu:
                startActivity(new Intent(MainActivity.this,PubuActivity.class));
                break;
            default:break;
        }
    }
}
