package com.wd.cela;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        drawerlayout=findViewById(R.id.drawerlayout);
//        navigationview=findViewById(R.id.navigationview);
//        navigationview.setItemIconTintList(null);
//        View headerView = navigationview.getHeaderView(0);
//        //获取头布局
//        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.page:
//                        IntentUtils.SetIntent(MainActivity.this,Tz.class);
//                        break;
//                        case R.id.read:
//                            IntentUtils.SetIntent(MainActivity.this,Tz.class);
//                            break;
//                            case R.id.found:
//                                IntentUtils.SetIntent(MainActivity.this,Tz.class);
//                                break;
//                                case R.id.myself:
//                                    IntentUtils.SetIntent(MainActivity.this,Tz.class);
//                                    break;
//                }
//                return true;
//            }
//        });




    }











//    public static class IntentUtils {
//        public static  void SetIntent(Context context, Class<?>mClass){
//            Intent intent = new Intent();
//            intent.setClass(context, mClass);
//            context.startActivity(intent);
//        }
//        public static  void SetIntentandfinish(Context context, Class<?>mClass, boolean isclose){
//            Intent intent = new Intent();
//            intent.setClass(context, mClass);
//            context.startActivity(intent);
//            if (isclose){
//                ((Activity)context).finish();
//            }
//        }
//        public static void SetIntentBundle(Context context, Class<?>mClass, Bundle bundle){
//            Intent intent = new Intent();
//            intent.setClass(context, mClass);
//            intent.putExtra("bundle",bundle);
//            context.startActivity(intent);
//        }
//    }

}
