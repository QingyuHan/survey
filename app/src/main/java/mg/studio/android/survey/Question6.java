package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static mg.studio.android.survey.DataConverter.IntToLayoutNum;

public class Question6 extends AppCompatActivity {
    private int layoutNum = 6;
    private Class nextActivity = Question7.class;
    private String[] answers = new String[13];
    private Button nextButton = null;
    private EditText editText = null;
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
        editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editText.getText().toString().isEmpty()){
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void LoadAnswers(){
        for (Integer i =1;i<13;++i){
            answers[i] = getIntent().getStringExtra("answer"+i.toString());
        }
    }
    private void SaveAnswers(){
        answers[layoutNum] = editText.getText().toString();
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
