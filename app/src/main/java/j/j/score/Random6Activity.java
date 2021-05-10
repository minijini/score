package j.j.score;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Random6Activity extends Activity {
    Button id1,id2,id3,id4,id5,id6; //점수 카운트
    Button btnstart;
    private Random rnd = new Random();

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getActionBar();
        actionBar.setTitle("순서정하기");
        setContentView(R.layout.activity_random6);



        id1 = (Button) findViewById(R.id.id1);
        id2 = (Button) findViewById(R.id.id2);
        id3 = (Button) findViewById(R.id.id3);
        id4 = (Button) findViewById(R.id.id4);
        id5 = (Button) findViewById(R.id.id5);
        id6 = (Button) findViewById(R.id.id6);

        btnstart = (Button) findViewById(R.id.btnstart);


        id1.setClickable(false);
        id2.setClickable(false);
        id3.setClickable(false);
        id4.setClickable(false);
        id5.setClickable(false);
        id6.setClickable(false);

        namenull();

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Random6Activity.this);

                // 제목셋팅
                alertDialogBuilder.setTitle("순서 정하기 시작");
                alertDialogBuilder
                        .setMessage("순서정하기를 하시겠습니까?\n※숫자가 낮은 사람이 먼저 시작입니다※")
                        .setCancelable(false)
                        .setPositiveButton("시작",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {

                                        startCountAnimation();

                                        new Handler().postDelayed(new Runnable() {//3초 후에 실행
                                            @Override
                                            public void run() {// 실행할 동작 코딩

                                        int num1 = rnd.nextInt(20);
                                        int num2 = rnd.nextInt(20);
                                        int num3 = rnd.nextInt(20);
                                        int num4 = rnd.nextInt(20);
                                        int num5 = rnd.nextInt(20);
                                        int num6 = rnd.nextInt(20);

                                        id1.setText(Integer.toString(num1));
                                        id2.setText(Integer.toString(num2));
                                        id3.setText(Integer.toString(num3));
                                        id4.setText(Integer.toString(num4));
                                        id5.setText(Integer.toString(num4));
                                        id6.setText(Integer.toString(num4));

                                        namenull();
                                            }
                                        }, 600);
                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        // 다이얼로그를 취소한다
                                        dialog.cancel();
                                    }
                                });

                // 다이얼로그 생성
                AlertDialog alertDialog = alertDialogBuilder.create();

                // 다이얼로그 보여주기
                alertDialog.show();

            }
        });


    }

    public void namenull(){
        SharedPreferences sf = getSharedPreferences("name6",MODE_PRIVATE);

        if(sf != null) {
            String name1 = sf.getString("edit1", "");
            String name2 = sf.getString("edit2", "");
            String name3 = sf.getString("edit3", "");
            String name4 = sf.getString("edit4", "");
            String name5 = sf.getString("edit5", "");
            String name6 = sf.getString("edit6", "");

            if(name1.equals("")){
                id1.setText("X");
            }
            if(name2.equals("")){
                id2.setText("X");
            }
            if(name3.equals("")){
                id3.setText("X");
            }
            if(name4.equals("")){
                id4.setText("X");
            }
            if(name5.equals("")){
                id5.setText("X");
            }
            if(name6.equals("")){
                id6.setText("X");
            }
        }
    }

    private void startCountAnimation() {
//        ValueAnimator animator = ValueAnimator.ofInt(0, 50);
//        animator.setDuration(5000);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            public void onAnimationUpdate(ValueAnimator animation) {
//                id1.setText(animation.getAnimatedValue().toString());
//                id2.setText(animation.getAnimatedValue().toString());
//                id3.setText(animation.getAnimatedValue().toString());
//                id4.setText(animation.getAnimatedValue().toString());
//            }
//        });
//        animator.start();


        ValueAnimator animator = ValueAnimator.ofInt(0, 20);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {

                id1.setText(animation.getAnimatedValue().toString());
                id2.setText(animation.getAnimatedValue().toString());
                id3.setText(animation.getAnimatedValue().toString());
                id4.setText(animation.getAnimatedValue().toString());
                id5.setText(animation.getAnimatedValue().toString());
                id6.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(500);
        animator.start();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.random, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.start:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Random6Activity.this);

                // 제목셋팅
                alertDialogBuilder.setTitle("순서 정하기 시작");
                alertDialogBuilder
                        .setMessage("순서정하기를 하시겠습니까?\n※숫자가 낮은 사람이 먼저 시작입니다※")
                        .setCancelable(false)
                        .setPositiveButton("시작",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {

                                        startCountAnimation();

                                        new Handler().postDelayed(new Runnable() {//3초 후에 실행
                                            @Override
                                            public void run() {// 실행할 동작 코딩

                                                int num1 = rnd.nextInt(20);
                                                int num2 = rnd.nextInt(20);
                                                int num3 = rnd.nextInt(20);
                                                int num4 = rnd.nextInt(20);
                                                int num5 = rnd.nextInt(20);
                                                int num6 = rnd.nextInt(20);

                                                id1.setText(Integer.toString(num1));
                                                id2.setText(Integer.toString(num2));
                                                id3.setText(Integer.toString(num3));
                                                id4.setText(Integer.toString(num4));
                                                id5.setText(Integer.toString(num5));
                                                id6.setText(Integer.toString(num6));

                                                namenull();
                                            }
                                        }, 600);
                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        // 다이얼로그를 취소한다
                                        dialog.cancel();
                                    }
                                });

                // 다이얼로그 생성
                AlertDialog alertDialog = alertDialogBuilder.create();

                // 다이얼로그 보여주기
                alertDialog.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    // 뒤로가기 버튼을 눌렀을 때의 오버라이드 메소드
    @Override
    public void onBackPressed() {

        finish();
        overridePendingTransition(0,0);
    } // in MyActivity
}
