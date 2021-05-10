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
import android.widget.TextView;

public class P5Activity extends Activity {
    Button id1,id2,id3,id4,id5; //점수 카운트
    Button btn1,btn2,btn3,btn4,btn5; //닉네임 변경
    Button plus1,plus2,plus3,plus4,plus5; //+
    Button minus1,minus2,minus3,minus4,minus5; //-
    EditText edit1,edit2,edit3,edit4,edit5;  //닉네임
    TextView txt1,txt2,txt3,txt4,txt5; // 닉네임

    String name1,name2,name3,name4,name5;
    int score1,score2,score3,score4,score5;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5);

        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        id1 = (Button) findViewById(R.id.id1);
        id2 = (Button) findViewById(R.id.id2);
        id3 = (Button) findViewById(R.id.id3);
        id4 = (Button) findViewById(R.id.id4);
        id5 = (Button) findViewById(R.id.id5);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);

        plus1 = (Button) findViewById(R.id.plus1);
        plus2 = (Button) findViewById(R.id.plus2);
        plus3 = (Button) findViewById(R.id.plus3);
        plus4 = (Button) findViewById(R.id.plus4);
        plus5 = (Button) findViewById(R.id.plus5);

        minus1 = (Button) findViewById(R.id.minus1);
        minus2 = (Button) findViewById(R.id.minus2);
        minus3 = (Button) findViewById(R.id.minus3);
        minus4 = (Button) findViewById(R.id.minus4);
        minus5 = (Button) findViewById(R.id.minus5);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
        edit5 = (EditText) findViewById(R.id.edit5);

        txt1 = (TextView) findViewById(R.id.text1);
        txt2 = (TextView) findViewById(R.id.text2);
        txt3 = (TextView) findViewById(R.id.text3);
        txt4 = (TextView) findViewById(R.id.text4);
        txt5 = (TextView) findViewById(R.id.text5);

        id1.setClickable(false);
        id2.setClickable(false);
        id3.setClickable(false);
        id4.setClickable(false);
        id5.setClickable(false);

       nameshared();

        SharedPreferences score = getSharedPreferences("score5",MODE_PRIVATE);


        if(score != null) {


            String s1 = score.getString("score1", "0");
            String s2 = score.getString("score2", "0");
            String s3 = score.getString("score3", "0");
            String s4 = score.getString("score4", "0");
            String s5 = score.getString("score5", "0");

            score1 = Integer.parseInt(s1);
            score2 = Integer.parseInt(s2);
            score3 = Integer.parseInt(s3);
            score4 = Integer.parseInt(s4);
            score5 = Integer.parseInt(s5);

            id1.setText(s1);
            id2.setText(s2);
            id3.setText(s3);
            id4.setText(s4);
            id5.setText(s5);
        }


        Button.OnClickListener onClickListener1 = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("name5",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                switch (view.getId()) {
                    case R.id.btn1 :

                        if (btn1.getText().toString().equals("변경") && !edit1.getText().toString().equals("")) {
                            txt1.setVisibility(View.VISIBLE);
                            edit1.setVisibility(View.INVISIBLE);

                            String text1 = edit1.getText().toString();
                            editor.putString("edit1",text1);
                            editor.commit();

                            dialog();

                        } else if (btn1.getText().toString().equals("변경")&&edit1.getText().toString().equals("")) {

                            txt1.setVisibility(View.INVISIBLE);
                            edit1.setVisibility(View.VISIBLE);

                            edit1.setText(name1);

                        } else if (!edit1.getText().toString().equals("")) {
                            btn1.setText("변경");
                            txt1.setVisibility(View.VISIBLE);
                            edit1.setVisibility(View.INVISIBLE);

                            String text1 = edit1.getText().toString();
                            editor.putString("edit1",text1);
                            editor.commit();


                            dialog();

                        } else {
                            btn1.setText("이름\n변경");
                        }

//                        }

                        break ;

                    case R.id.btn2 :


                        if (btn2.getText().toString().equals("변경") && !edit2.getText().toString().equals("")) {
                            txt2.setVisibility(View.VISIBLE);
                            edit2.setVisibility(View.INVISIBLE);

                            String text2 = edit2.getText().toString();
                            editor.putString("edit2",text2);
                            editor.commit();

                            dialog();

                        } else if (btn2.getText().toString().equals("변경")&&edit2.getText().toString().equals("")) {

                            txt2.setVisibility(View.INVISIBLE);
                            edit2.setVisibility(View.VISIBLE);

                            edit2.setText(name2);

                        } else if (!edit2.getText().toString().equals("")) {
                            btn2.setText("변경");
                            txt2.setVisibility(View.VISIBLE);
                            edit2.setVisibility(View.INVISIBLE);

                            String text2 = edit2.getText().toString();
                            editor.putString("edit2",text2);
                            editor.commit();


                            dialog();

                        } else {
                            btn2.setText("이름\n변경");
                        }

                        break ;


                    case R.id.btn3 :
                        if (btn3.getText().toString().equals("변경") && !edit3.getText().toString().equals("")) {
                            txt3.setVisibility(View.VISIBLE);
                            edit3.setVisibility(View.INVISIBLE);

                            String text3 = edit3.getText().toString();
                            editor.putString("edit3",text3);
                            editor.commit();

                            dialog();

                        } else if (btn3.getText().toString().equals("변경")&&edit3.getText().toString().equals("")) {

                            txt3.setVisibility(View.INVISIBLE);
                            edit3.setVisibility(View.VISIBLE);

                            edit3.setText(name3);

                        } else if (!edit3.getText().toString().equals("")) {
                            btn3.setText("변경");
                            txt3.setVisibility(View.VISIBLE);
                            edit3.setVisibility(View.INVISIBLE);

                            String text3 = edit3.getText().toString();
                            editor.putString("edit3",text3);
                            editor.commit();


                            dialog();

                        } else {
                            btn3.setText("이름\n변경");
                        }
                        break;

                    case R.id.btn4 :
                        if (btn4.getText().toString().equals("변경") && !edit4.getText().toString().equals("")) {
                            txt4.setVisibility(View.VISIBLE);
                            edit4.setVisibility(View.INVISIBLE);

                            String text4 = edit4.getText().toString();
                            editor.putString("edit4",text4);
                            editor.commit();

                            dialog();

                        } else if (btn4.getText().toString().equals("변경")&&edit4.getText().toString().equals("")) {

                            txt4.setVisibility(View.INVISIBLE);
                            edit4.setVisibility(View.VISIBLE);

                            edit4.setText(name4);

                        } else if (!edit4.getText().toString().equals("")) {
                            btn4.setText("변경");
                            txt4.setVisibility(View.VISIBLE);
                            edit4.setVisibility(View.INVISIBLE);

                            String text4 = edit4.getText().toString();
                            editor.putString("edit4",text4);
                            editor.commit();


                            dialog();

                        } else {
                            btn4.setText("이름\n변경");
                        }
                        break ;

                    case R.id.btn5 :
                        if (btn5.getText().toString().equals("변경") && !edit5.getText().toString().equals("")) {
                            txt5.setVisibility(View.VISIBLE);
                            edit5.setVisibility(View.INVISIBLE);

                            String text5 = edit5.getText().toString();
                            editor.putString("edit5",text5);
                            editor.commit();

                            dialog();

                        } else if (btn5.getText().toString().equals("변경")&&edit5.getText().toString().equals("")) {

                            txt5.setVisibility(View.INVISIBLE);
                            edit5.setVisibility(View.VISIBLE);

                            edit5.setText(name5);

                        } else if (!edit5.getText().toString().equals("")) {
                            btn5.setText("변경");
                            txt5.setVisibility(View.VISIBLE);
                            edit5.setVisibility(View.INVISIBLE);

                            String text5 = edit5.getText().toString();
                            editor.putString("edit5",text5);
                            editor.commit();


                            dialog();

                        } else {
                            btn5.setText("이름\n변경");
                        }
                        break ;
                }
            }
        } ;

        Button.OnClickListener onClickListener2 = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("score5",MODE_PRIVATE);
                editor = sharedPreferences.edit();

                switch (view.getId()) {
                    case R.id.plus1 :
                        score1 +=1;
                        id1.setText(Integer.toString(score1));

                        String text1 = Integer.toString(score1);
                        editor.putString("score1",text1);
                        editor.commit();
                        break ;

                    case R.id.plus2 :
                        score2 +=1;
                        id2.setText(Integer.toString(score2));

                        String text2 = Integer.toString(score2);
                        editor.putString("score2",text2);
                        editor.commit();
                        break ;

                    case R.id.plus3 :
                        score3 +=1;
                        id3.setText(Integer.toString(score3));

                        String text3 = Integer.toString(score3);
                        editor.putString("score3",text3);
                        editor.commit();
                        break ;

                    case R.id.plus4 :
                        score4 +=1;
                        id4.setText(Integer.toString(score4));

                        String text4 = Integer.toString(score4);
                        editor.putString("score4",text4);
                        editor.commit();
                        break ;

                    case R.id.plus5 :
                        score5 +=1;
                        id5.setText(Integer.toString(score5));

                        String text5 = Integer.toString(score5);
                        editor.putString("score5",text5);
                        editor.commit();
                        break ;
                }
            }
        } ;

        Button.OnClickListener onClickListener3 = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences = getSharedPreferences("score5",MODE_PRIVATE);
                editor = sharedPreferences.edit();

                switch (view.getId()) {

                    case R.id.minus1 :
                        if(score1 > 0){
                            score1 -=1;
                        }
                        id1.setText(Integer.toString(score1));

                        String text1 = Integer.toString(score1);
                        editor.putString("score1",text1);
                        editor.commit();

                        break ;

                    case R.id.minus2 :
                        if(score2 > 0){
                            score2 -=1;
                        }
                        id2.setText(Integer.toString(score2));

                        String text2 = Integer.toString(score2);
                        editor.putString("score2",text2);
                        editor.commit();

                        break ;

                    case R.id.minus3 :
                        if(score3 > 0){
                            score3 -=1;
                        }
                        id3.setText(Integer.toString(score3));

                        String text3 = Integer.toString(score3);
                        editor.putString("score3",text3);
                        editor.commit();
                        break ;

                    case R.id.minus4 :
                        if(score4 > 0){
                            score4 -=1;
                        }
                        id4.setText(Integer.toString(score4));

                        String text4 = Integer.toString(score4);
                        editor.putString("score4",text4);
                        editor.commit();

                        break ;

                    case R.id.minus5 :
                        if(score5 > 0){
                            score5 -=1;
                        }
                        id5.setText(Integer.toString(score5));

                        String text5 = Integer.toString(score5);
                        editor.putString("score5",text5);
                        editor.commit();

                        break ;
                }
            }
        } ;



        btn1.setOnClickListener(onClickListener1);
        btn2.setOnClickListener(onClickListener1);
        btn3.setOnClickListener(onClickListener1);
        btn4.setOnClickListener(onClickListener1);
        btn5.setOnClickListener(onClickListener1);

        plus1.setOnClickListener(onClickListener2);
        plus2.setOnClickListener(onClickListener2);
        plus3.setOnClickListener(onClickListener2);
        plus4.setOnClickListener(onClickListener2);
        plus5.setOnClickListener(onClickListener2);

        minus1.setOnClickListener(onClickListener3);
        minus2.setOnClickListener(onClickListener3);
        minus3.setOnClickListener(onClickListener3);
        minus4.setOnClickListener(onClickListener3);
        minus5.setOnClickListener(onClickListener3);


    }

    public void nameshared(){
        SharedPreferences sf = getSharedPreferences("name5",MODE_PRIVATE);


        if(sf != null) {
            name1 = sf.getString("edit1", "");
            name2 = sf.getString("edit2", "");
            name3 = sf.getString("edit3", "");
            name4 = sf.getString("edit4", "");
            name5 = sf.getString("edit5", "");

            txt1.setText(name1);
            txt2.setText(name2);
            txt3.setText(name3);
            txt4.setText(name4);
            txt5.setText(name5);


        }

        if(!txt1.getText().toString().equals("")){
            edit1.setVisibility(View.INVISIBLE);
            txt1.setVisibility(View.VISIBLE);

            btn1.setText("변경");
        }
        if(!txt2.getText().toString().equals("")){
            edit2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.VISIBLE);

            btn2.setText("변경");
        }
        if(!txt3.getText().toString().equals("")){
            edit3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.VISIBLE);

            btn3.setText("변경");
        }

        if(!txt4.getText().toString().equals("")){
            edit4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.VISIBLE);

            btn4.setText("변경");
        }

        if(!txt5.getText().toString().equals("")){
            edit5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.VISIBLE);

            btn5.setText("변경");
        }
    }

    public void reset(){
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        score5 = 0;

        id1.setText(Integer.toString(score1));
        id2.setText(Integer.toString(score2));
        id3.setText(Integer.toString(score3));
        id4.setText(Integer.toString(score4));
        id5.setText(Integer.toString(score5));

        SharedPreferences scorerm = getSharedPreferences("score5", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = scorerm.edit();
        editor.remove("score1");
        editor.remove("score2");
        editor.remove("score3");
        editor.remove("score4");
        editor.remove("score5");
        editor.clear();
        editor.commit();
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.random:
                Intent intent = new Intent(this, Random5Activity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                return true;


            case R.id.reset:
                reset();

                return true;


            case R.id.exit:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                // 제목셋팅
                alertDialogBuilder.setTitle("프로그램 종료");
                alertDialogBuilder
                        .setMessage("프로그램을 종료할 것입니까?")
                        .setCancelable(false)
                        .setPositiveButton("종료",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        // 프로그램을 종료한다
                                        int pid = android.os.Process.myPid();
                                        android.os.Process.killProcess(pid); //완전종료되는것

                                        finish();
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

    public void dialog(){


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(P5Activity.this);
        // 제목셋팅
        alertDialogBuilder.setTitle("이름 변경");
        alertDialogBuilder
                .setMessage("이름이 변경되었습니다")
                .setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                imm.hideSoftInputFromWindow(edit1.getWindowToken(), 0);
                                imm.hideSoftInputFromWindow(edit2.getWindowToken(), 0);
                                imm.hideSoftInputFromWindow(edit3.getWindowToken(), 0);
                                imm.hideSoftInputFromWindow(edit4.getWindowToken(), 0);
                                imm.hideSoftInputFromWindow(edit5.getWindowToken(), 0);

                                nameshared();


                                edit1.setText("");
                                edit2.setText("");
                                edit3.setText("");
                                edit4.setText("");
                                edit5.setText("");

                                dialog.cancel();
                            }
                        });
        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();

        // 다이얼로그 보여주기
        alertDialog.show();
    }



    // 뒤로가기 버튼을 눌렀을 때의 오버라이드 메소드
    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0,0);
    } // in MyActivity
}
