package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_survey);
        InitializeWidgets();
    }
    private void InitializeWidgets(){
        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityController.Finish();//close app
            }
        });
    }
}
