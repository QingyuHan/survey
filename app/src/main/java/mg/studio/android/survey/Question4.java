package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static mg.studio.android.survey.ActivityController.IntToLayoutNum;

public class Question4 extends AppCompatActivity {
    private String[] answers = new String[13];
    private Button nextButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        LoadAnswers();
        setContentView(IntToLayoutNum(4));
        InitializeWidgets();
    }
    private void InitializeWidgets(){
        nextButton = findViewById(R.id.nextButton);
        for (int i =1;i<=7;++i){
            ((CheckBox)findViewById(ActivityController.IntToCheckBoxNum(i))).setOnCheckedChangeListener(new OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b){
                        nextButton.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
    private void LoadAnswers(){
        for (Integer i =1;i<13;++i){
            answers[i] = getIntent().getStringExtra("answer"+i.toString());
        }
    }
    private void SaveAnswers(){
        for (int i =1;i<=7;++i){
            CheckBox checkBox = findViewById(ActivityController.IntToCheckBoxNum(i));
            if (checkBox.isChecked()){
                answers[4]+=checkBox.getText().toString()+"\n";
            }
        }
    }
    public void NextButtonDown(View view){
        SaveAnswers();
        Intent intent =  new Intent();
        intent.setClass(this, Question5.class);
        for (Integer i =1;i<13;++i){
            intent.putExtra("answer"+i.toString(),answers[i]);
        }
        startActivity(intent);
    }
}
