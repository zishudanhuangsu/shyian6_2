package com.example.shyian6_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
//                EditText et=(EditText)findViewById(R.id.edittext);
//                String url=et.getText().toString();
//
//                Intent intent=new Intent(MainActivity.this,Brower.class);
//                intent.putExtra("url",url);
//                startActivity(intent);
            }
        });

    }
    private void showPopupMenu(View view)
    {
        PopupMenu menu = new PopupMenu(this,view);
        menu.getMenuInflater().inflate(R.menu.main_menu,menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                if(item.getItemId()==R.id.mybrower_item)
                {
                EditText et=(EditText)findViewById(R.id.edittext);
                String url=et.getText().toString();
                Intent intent=new Intent(MainActivity.this,Brower.class);
                intent.putExtra("url",url);
                startActivity(intent);

                }
                else if(item.getItemId()==R.id.otherapp_item)
                {
                    EditText et=(EditText)findViewById(R.id.edittext);
                    String url=et.getText().toString();
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));

                    startActivity(intent);
                }
                return true;
            }
        });
//        menu.setOnDismissListener(new PopupMenu.OnDismissListener() {
//            @Override
//            public void onDismiss(PopupMenu menu) {
//                Toast.makeText(MainActivity.this, "关闭了", Toast.LENGTH_SHORT).show();
//            }
//        });
        menu.show();
    }
}
