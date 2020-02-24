package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int layoutNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetLayout(layoutNum);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode== KeyEvent.KEYCODE_BACK){
            PreLayout();
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    private void SaveAnswer(){
        //Need more details to complete
    }
    private void LoadAnswer(){
        //Need more details to complete
    }
    private void NextLayout(){
        SaveAnswer();
        ++layoutNum;
        if(layoutNum>13){
            layoutNum=13;
            finish();
        }
        else {
            SetLayout(layoutNum);
        }
    }
    private void PreLayout(){
        LoadAnswer();
        --layoutNum;
        if(layoutNum<0){
            layoutNum=0;
        }
        else{
            SetLayout(layoutNum);
        }
    }
    private void SetLayout(int num){
        setContentView(Int2LayoutNum(num));
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NextLayout();
            }
        });
        //Other components' initialization

    }
    private int Int2LayoutNum(int num){
        int layoutNum = R.layout.welcome;
        switch (num){
            case 1:
                layoutNum = R.layout.question_one;
                break;
            case 2:
                layoutNum = R.layout.question_two;
                break;
            case 3:
                layoutNum = R.layout.question_three;
                break;
            case 4:
                layoutNum = R.layout.question_four;
                break;
            case 5:
                layoutNum = R.layout.question_five;
                break;
            case 6:
                layoutNum = R.layout.question_six;
                break;
            case 7:
                layoutNum = R.layout.question_seven;
                break;
            case 8:
                layoutNum = R.layout.question_eight;
                break;
            case 9:
                layoutNum = R.layout.question_nine;
                break;
            case 10:
                layoutNum = R.layout.question_ten;
                break;
            case 11:
                layoutNum = R.layout.question_eleven;
                break;
            case 12:
                layoutNum = R.layout.question_twelve;
                break;
            case 13:
                layoutNum = R.layout.finish_survey;
                break;
            default:
                break;
        }
        return layoutNum;
    }
}