package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import static mg.studio.android.survey.DataConverter.IntToLayoutNum;

    public class Question5 extends AppCompatActivity {
        private int layoutNum = 5;
        private Class nextActivity = Question6.class;
        private String[] answers = new String[13];
        private Button nextButton = null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            ActivityController.activities.add(this);
            super.onCreate(savedInstanceState);
            LoadAnswers();
            setContentView(IntToLayoutNum(layoutNum));
            InitializeWidgets();
        }
        private void InitializeWidgets(){
            nextButton = findViewById(R.id.nextButton);
            for (int i =1;i<7;++i){
                ((CheckBox)findViewById(DataConverter.IntToCheckBoxNum(i))).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
            for (int i =1;i<7;++i){
                CheckBox checkBox = findViewById(DataConverter.IntToCheckBoxNum(i));
                if (checkBox.isChecked()){
                    answers[layoutNum]+=checkBox.getText().toString()+"\n";
                }
            }
        }
        public void NextButtonDown(View view){
            SaveAnswers();
            Intent intent =  new Intent();
            intent.setClass(this, nextActivity);
            for (Integer i =1;i<13;++i){
                intent.putExtra("answer"+i.toString(),answers[i]);
            }
            startActivity(intent);
        }
    }
