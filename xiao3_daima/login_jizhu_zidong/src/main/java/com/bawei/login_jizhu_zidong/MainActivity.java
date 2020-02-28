package com.bawei.login_jizhu_zidong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edituser,editpass;
    CheckBox jizhu,zidong;
    Button button;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件id
        iniview();

        sp=getSharedPreferences("", Context.MODE_PRIVATE);
        boolean jizhub = sp.getBoolean("jizhu", false);
        if(jizhub){
            String user = sp.getString("user", "");
            String pass = sp.getString("pass", "");
            edituser.setText(user);
            editpass.setText(pass);
            jizhu.setChecked(true);
        }

        boolean zidongb = sp.getBoolean("自动", false);
        if(zidongb){
            startActivity(new Intent(MainActivity.this,Tiaozhuan.class));
            finish();
        }

        jizhu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    zidong.setChecked(false);
                }
            }
        });

        zidong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                jizhu.setChecked(b);
            }
        });




    }

    public void dl(View view) {
        String user=edituser.getText().toString();
        String pass=editpass.getText().toString();
        if(user.equals("")&&pass.equals("")){
            Toast.makeText(MainActivity.this,"输入不可以为空",Toast.LENGTH_LONG).show();
        }

        if(user.equals("2318279444")&&pass.equals("1")){
            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
            boolean jizhua = jizhu.isChecked();
            boolean zidonga = zidong.isChecked();
            SharedPreferences.Editor edit = sp.edit();
            if(jizhua){
                edit.putString("user",user);
                edit.putString("pass",pass);
            }
            edit.putBoolean("jizhu",jizhua);
            edit.putBoolean("自动",zidonga);
            boolean commit = edit.commit();
            if(commit){
                if(user.equals("")&&pass.equals("")){
                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(MainActivity.this,Tiaozhuan.class));
                finish();
            }else {
                Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
            }
        }
    }


    private void iniview() {
        edituser=findViewById(R.id.edituser);
        editpass=findViewById(R.id.editpass);
        jizhu=findViewById(R.id.jizhu);
        zidong=findViewById(R.id.zidong);
        button=findViewById(R.id.button);
    }
}
