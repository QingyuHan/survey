package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.*;
import static mg.studio.android.survey.DataConverter.IntToLayoutNum;

public class WelcomeActivity extends AppCompatActivity{
    private Button nextButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        setContentView(IntToLayoutNum(0));
        ActivityController.activities.add(this);
        CheckBox acceptCheckBox = findViewById(R.id.acceptCheckBox);
        nextButton = findViewById(R.id.nextButton);
        acceptCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    nextButton.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode== KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    public void NextButtonDown(View view){
        Intent intent = new Intent();
        intent.setClass(this, Question1.class);
        for (Integer i=1;i<13;++i)
            intent.putExtra("answer"+i.toString(),"");
        startActivity(intent);
    }

}