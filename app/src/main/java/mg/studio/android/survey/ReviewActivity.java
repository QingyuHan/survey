package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static mg.studio.android.survey.ActivityController.IntToLayoutNum;

public class ReviewActivity extends AppCompatActivity {
    private int layoutNum = 13;
    private Class nextActivity = FinishActivity.class;
    private String[] answers = new String[13];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        LoadAnswers();
        setContentView(IntToLayoutNum(layoutNum));
        InitializeWidgets();
    }
    private void InitializeWidgets(){
        TextView textView = findViewById(R.id.textView1);
        String string = new String("");
        for (int i = 1;i<13;++i){
            string+= getResources().getString(ActivityController.IntToQuestionNum(i));
            string+="\n    ";
            string+=answers[i];
            string+="\n\n";
        }
        textView.setText(string);
    }
    private void LoadAnswers(){
        for (Integer i =1;i<13;++i){
            answers[i] = getIntent().getStringExtra("answer"+i.toString());
        }
    }
    private void SaveAnswers(){
    }
    public void NextButtonDown(View view){
        SaveAnswers();
        Intent intent =  new Intent();
        intent.setClass(this, nextActivity);
        startActivity(intent);
    }
}
