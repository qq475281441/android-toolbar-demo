package com.example.zhouwenping.actionbardemo;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, View.OnClickListener {
    private SearchView searchView;
    private MenuItem search_cancel;
    private MenuItem search_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        //透明状态栏
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);//让标题栏占用状态栏
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        searchView = findViewById(R.id.search_view);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);//绑定搜索监听事件
//          显示返回按钮
//        ActionBar bar = getSupportActionBar();
//        bar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 查找menuItem需要放在这个方法里
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        search_cancel = menu.findItem(R.id.cancel_search);//取消搜索
        search_start = menu.findItem(R.id.search_start);//开始搜索的放大镜
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_start:
                searchView.setVisibility(searchView.VISIBLE);
                searchView.onActionViewExpanded();
                search_start.setVisible(false);
                search_cancel.setVisible(true);
                break;
            case R.id.cancel_search:
                searchView.setVisibility(searchView.GONE);
                searchView.onActionViewCollapsed();
                search_start.setVisible(true);
                search_cancel.setVisible(false);
                break;
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onClick(View view) {

    }
}
