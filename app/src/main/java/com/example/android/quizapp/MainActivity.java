package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    /***
     * 判断第2题的答案，选对返回1，错返回0
     * @return
     */
    private int getQ2Answers(){
        boolean q2_a = false;
        boolean q2_b = false;
        boolean q2_c = false;
        boolean q2_d = false;

        CheckBox cb_q2_a = (CheckBox) findViewById(R.id.q2_a);
        CheckBox cb_q2_b = (CheckBox) findViewById(R.id.q2_b);
        CheckBox cb_q2_c = (CheckBox) findViewById(R.id.q2_c);
        CheckBox cb_q2_d = (CheckBox) findViewById(R.id.q2_d);

        q2_a = cb_q2_a.isChecked();
        q2_b = cb_q2_b.isChecked();
        q2_c = cb_q2_c.isChecked();
        q2_d = cb_q2_d.isChecked();


        if(q2_a && q2_b && !q2_c && !q2_d){
            return 1;
        }else{
            return 0;
        }
    }

    /***
     * 判断第一题的答案，选对返回1，错返回0
     * @return
     */
    private int getQ1Answers() {
        boolean q1_a = false;


        RadioButton rb_q1_a = (RadioButton) findViewById(R.id.q1_a);


        q1_a = rb_q1_a.isChecked();


        if (q1_a){
            return 1;
        }else{
            return 0;
        }
    }

    /***
     * 判断第3题的答案，选对返回1，错返回0
     * @return
     */
    private int getQ3Answers() {
        boolean q3_a = false;


        RadioButton rb_q3_a = (RadioButton) findViewById(R.id.q3_a);


        q3_a = rb_q3_a.isChecked();


        if (q3_a){
            return 1;
        }else{
            return 0;
        }
    }

    /***
     * 判断第4题的答案，选对返回1，错返回0
     * @return
     */
    private int getQ4Answers(){
        TextView q4 = (TextView) findViewById(R.id.q4_text);
        String answerQ4 = q4.getText().toString().toLowerCase();

        String correctAnswerQ4Key1 = "vertical";
        String correctAnswerQ4Key2 = "vertical";

        if(answerQ4.contains(correctAnswerQ4Key1) && answerQ4.contains(correctAnswerQ4Key2)){
            return 1;
        }else {
            return 0;
        }

    }

    /***
     * 提交答案处理程序
     *
     * @param view
     */
    public void submitAnswer(View view) {
        //所得分数
        int score = 0;
        //用来显示答案提示信息
        String answerMessage = "";

        //每个题目判断函数答对得1分，答错不得分，直接相加就得到总分。
        score = getQ1Answers() +getQ2Answers() + getQ3Answers() +getQ4Answers();

        answerMessage += "Your score is "+score+".";

        //满分提示和有错误提示不一样
        if(score == 4){
            answerMessage += "Congratulations! All the answers is correct!";
        }else{
            answerMessage += "The error question is ";

            //找出错误的题目号
            if(getQ1Answers()!=1){
                answerMessage += "Q1.";
            }
            if(getQ2Answers()!=1){
                answerMessage += "Q2.";
            }
            if(getQ3Answers()!=1){
                answerMessage += "Q3.";
            }
            if(getQ4Answers()!=1){
                answerMessage += "Q4.";
            }
        }

        Toast.makeText(getApplicationContext(),answerMessage,Toast.LENGTH_LONG).show();

    }
}
