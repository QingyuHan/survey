package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.*;

public class WelcomeActivity extends AppCompatActivity{
    private Button nextButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        CheckBox acceptCheckBox = findViewById(R.id.acceptCheckBox);
        nextButton = findViewById(R.id.nextButton);
        //show the next button when the accept checkbox get clicked
        acceptCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    nextButton.setVisibility(View.VISIBLE);
            }
        });
    }
    //block back key
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode== KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    public void NextButtonDown(View view){
        Intent intent = new Intent();
        intent.setClass(this, QuestionActivity.class);
        startActivity(intent);
    }

}