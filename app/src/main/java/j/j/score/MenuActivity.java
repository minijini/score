package j.j.score;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends Activity {
    LinearLayout id1,id2,id3,id4,id5; //점수 카운트
    private OnBackPressedListener mBackListener; // 리스너 객체 생성
    private Toast toast;
    private long pressedTime = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        id1 = (LinearLayout) findViewById(R.id.id1);
        id2 = (LinearLayout) findViewById(R.id.id2);
        id3 = (LinearLayout) findViewById(R.id.id3);
        id4 = (LinearLayout) findViewById(R.id.id4);
        id5 = (LinearLayout) findViewById(R.id.id5);



        LinearLayout.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.id1 :
                        Intent intent = new Intent(MenuActivity.this,P2Activity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                        break ;

                    case R.id.id2 :
                        Intent intent2 = new Intent(MenuActivity.this,P3Activity.class);
                        startActivity(intent2);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);

                        break ;

                    case R.id.id3 :
                        Intent intent3 = new Intent(MenuActivity.this,P4Activity.class);
                        startActivity(intent3);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);

                        break ;

                    case R.id.id4 :
                        Intent intent4 = new Intent(MenuActivity.this,P5Activity.class);
                        startActivity(intent4);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);

                        break ;

                    case R.id.id5 :
                        Intent intent5 = new Intent(MenuActivity.this,P6Activity.class);
                        startActivity(intent5);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);

                        break ;
                }
            }
        } ;



        id1.setOnClickListener(onClickListener);
        id2.setOnClickListener(onClickListener);
        id3.setOnClickListener(onClickListener);
        id4.setOnClickListener(onClickListener);
        id5.setOnClickListener(onClickListener);


    }



    // 리스너 생성
    public interface OnBackPressedListener {
        void onBack();
    }

    public void setOnBackPressedListener(OnBackPressedListener listener) {
        mBackListener = listener;
    }

    // 뒤로가기 버튼을 눌렀을 때의 오버라이드 메소드
    @Override
    public void onBackPressed() {
        // 다른 Fragment 에서 리스너를 설정했을 때 처리
        if (mBackListener != null) {
            mBackListener.onBack();
            Log.d("!!!", "Listener is not null");

            // 리스너가 설정되지 않은 상태(예를들어 메인Fragment)라면
            // 뒤로가기 버튼을 연속적으로 두번 눌렀을 때 앱이 종료됩니다.
        } else {

            Log.d("!!!", "Listener is null");
            if (pressedTime == 0) {

                toast = Toast.makeText(this, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
                toast.show();
                pressedTime = System.currentTimeMillis();
            } else {
                int seconds = (int) (System.currentTimeMillis() - pressedTime);

                if (seconds > 2000) {
                    toast = Toast.makeText(this, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    pressedTime = 0;
                } else {
                    super.onBackPressed();
                    Log.d("!!!", "onBackPressed : finish, killProcess");

                    // 프로그램을 종료한다
                    int pid = android.os.Process.myPid();
                    android.os.Process.killProcess(pid); //완전종료되는것
                    finish();


                }
            }
        }
    } // in MyActivity
}
