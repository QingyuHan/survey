package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import static mg.studio.android.survey.ActivityController.Int2LayoutNum;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Int2LayoutNum(0));
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode== KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    public void NextButtonDown(View view){

    }
    //used activity controller to instead
    /*
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
    */

}