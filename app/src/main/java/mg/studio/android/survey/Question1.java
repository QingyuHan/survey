package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static mg.studio.android.survey.ActivityController.IntToLayoutNum;


public class Question1 extends AppCompatActivity{
    private String[] answers = new String[13];
    private Button nextButton = null;
    private RadioGroup radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        LoadAnswers();
        setContentView(IntToLayoutNum(1));
        InitializeWidgets();
    }
    private void InitializeWidgets(){
        nextButton = findViewById(R.id.nextButton);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                nextButton.setVisibility(View.VISIBLE);
            }
        });
    }
    private void LoadAnswers(){
        for (Integer i =1;i<13;++i){
            answers[i] = getIntent().getStringExtra("answer"+i.toString());
        }
    }
    private void SaveAnswers(){
        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        answers[1] = radioButton.getText().toString();
    }
    public void NextButtonDown(View view){
        SaveAnswers();
        Intent intent =  new Intent();
        intent.setClass(this, Question2.class);
        for (Integer i =1;i<13;++i){
            intent.putExtra("answer"+i.toString(),answers[i]);
        }
        startActivity(intent);
    }
}
