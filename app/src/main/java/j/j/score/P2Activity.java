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

public class P2Activity extends Activity {
    Button id1,id2; //점수 카운트
    Button btn1,btn2; //닉네임 변경
    Button plus1,plus2; //+
    Button minus1,minus2; //-
    EditText edit1,edit2;  //닉네임
    TextView txt1,txt2; // 닉네임

    int score1,score2;

    String name1,name2;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);

        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        id1 = (Button) findViewById(R.id.id1);
        id2 = (Button) findViewById(R.id.id2);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);


        plus1 = (Button) findViewById(R.id.plus1);
        plus2 = (Button) findViewById(R.id.plus2);


        minus1 = (Button) findViewById(R.id.minus1);
        minus2 = (Button) findViewById(R.id.minus2);


        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        txt1 = (TextView) findViewById(R.id.text1);
        txt2 = (TextView) findViewById(R.id.text2);



        id1.setClickable(false);
        id2.setClickable(false);




        nameshared();


        SharedPreferences score = getSharedPreferences("score2",MODE_PRIVATE);

        if(score != null) {


            String s1 = score.getString("score1", "0");
            String s2 = score.getString("score2", "0");


            score1 = Integer.parseInt(s1);
            score2 = Integer.parseInt(s2);


            id1.setText(s1);
            id2.setText(s2);

        }


        Button.OnClickListener onClickListener1 = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("name2",MODE_PRIVATE);
                editor = sharedPreferences.edit();

                switch (view.getId()) {
                    case R.id.btn1 :



//                        Log.d("p2","edit1 == "+edit1.getText().toString());
//
//                        if (edit1.getText().toString().equals("")) {
//
//                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(P2Activity.this);
//
//                            // 제목셋팅
//                            alertDialogBuilder.setTitle("이름");
//                            alertDialogBuilder
//                                    .setMessage("이름을 입력해주세요!")
//                                    .setCancelable(false)
//                                    .setPositiveButton("확인",
//                                            new DialogInterface.OnClickListener() {
//                                                public void onClick(
//                                                        DialogInterface dialog, int id) {
//                                                   dialog.dismiss();
//                                                }
//                                            });
//
//                            // 다이얼로그 생성
//                            AlertDialog alertDialog = alertDialogBuilder.create();
//
//                            // 다이얼로그 보여주기
//                            alertDialog.show();
//                        }else {


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

//                        }



                        break ;


                }
            }
        } ;

        Button.OnClickListener onClickListener2 = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("score2",MODE_PRIVATE);
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


                }
            }
        } ;

        Button.OnClickListener onClickListener3 = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences = getSharedPreferences("score2",MODE_PRIVATE);
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


                }
            }
        } ;




        btn1.setOnClickListener(onClickListener1);
        btn2.setOnClickListener(onClickListener1);


        plus1.setOnClickListener(onClickListener2);
        plus2.setOnClickListener(onClickListener2);


        minus1.setOnClickListener(onClickListener3);
        minus2.setOnClickListener(onClickListener3);



    }

    public void nameshared(){
        SharedPreferences sf = getSharedPreferences("name2",MODE_PRIVATE);


        if(sf != null) {
           name1 = sf.getString("edit1", "");
            name2 = sf.getString("edit2", "");

            txt1.setText(name1);
            txt2.setText(name2);


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
    }

    public void reset(){
        score1 = 0;
        score2 = 0;


        id1.setText(Integer.toString(score1));
        id2.setText(Integer.toString(score2));


        SharedPreferences scorerm = getSharedPreferences("score2", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = scorerm.edit();
        editor.remove("score1");
        editor.remove("score2");

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
                Intent intent = new Intent(this, Random2Activity.class);
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


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(P2Activity.this);
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
                                nameshared();

                                edit1.setText("");
                                edit2.setText("");
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
