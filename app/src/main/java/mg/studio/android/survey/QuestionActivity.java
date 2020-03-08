package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class QuestionActivity extends AppCompatActivity{
    private Button nextButton = null;
    private RadioGroup radioGroup = null;
    private TextView questionName = null;
    private TextView questionTitle = null;
    private QuestionFilter questionFilter = null;
    private int questionIndex = 0;
    private List<Integer> answerIndexes = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        SaveSampleJSON();
        //load sample.json
        questionFilter = new QuestionFilter(LoadSurveyJSON("sample.json"),this);
        ClearContent();
        InitializeWidgets();
    }
    //save sample.json to test
    private void SaveSampleJSON(){
        String data = "{\"survey\":{\"id\":\"12344134\",\"len\":\"2\",\"questions\":[{\"type\":\"single\",\"question\":\"How well do the professors teach at this university?\",\"options\":[{\"1\":\"Extremely well\"},{\"2\":\"Very well\"}]},{\"type\":\"single\",\"question\":\"How effective is the teaching outside yur major at the univesrity?\",\"options\":[{\"1\":\"Extremetly effective\"},{\"2\":\"Very effective\"},{\"3\":\"Somewhat effective\"},{\"4\":\"Not so effective\"},{\"5\":\"Not at all effective\"}]}]}}";
        String path = getExternalFilesDir(null).getAbsolutePath();
        String fileName = "sample.json";
        File dirFile = new File(path);
        if(!dirFile.exists()){
            if(!dirFile.mkdirs()){
                return;
            }
        }
        File file = new File(path+File.separator+fileName);

        try {
            if (!file.exists()){
                if (!file.createNewFile()){
                    Toast toast=Toast.makeText(this,"creating failed",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
            }
            PrintStream out=new PrintStream(new FileOutputStream(file));
            out.print(data);//output json
            out.close();
        } catch (Exception e) {
            Toast toast=Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
    }
    //load json string from sample.js
    private String LoadSurveyJSON(String fileName){
        String path = getExternalFilesDir(null).getAbsolutePath();
        File file = new File(path+File.separator+fileName);
        String encoding = "UTF-8";
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(fileContent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
    private void InitializeWidgets(){
        nextButton = findViewById(R.id.nextButton);
        radioGroup = findViewById(R.id.radioGroup);
        questionName = findViewById(R.id.questionName);
        questionTitle = findViewById(R.id.questionTitle);
        //show the next button when any radio button clicked
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                nextButton.setVisibility(View.VISIBLE);
            }
        });
        LoadQuestion();
    }
    //put and set question widgets
    private void LoadQuestion(){
        //title and content
        questionTitle.setText("Question "+Integer.toString(questionIndex+1));
        QuestionFilter.Question question = questionFilter.questions.get(questionIndex);
        questionName.setText(question.name);
        //radio buttons
        for(int i = 0; i<question.options.size();++i){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(question.options.get(i));
            radioGroup.addView(radioButton,radioGroup.getChildCount());
        }
    }
    //save single answers to list
    private void SaveAnswers(){
        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        answerIndexes.add(radioGroup.indexOfChild(radioButton));
    }
    private void ClearContent(){
        setContentView(R.layout.question);
    }
    public void NextButtonDown(View view){
        SaveAnswers();
        //still have questions not be accessed
        if(questionIndex<questionFilter.questions.size()-1){
            ++questionIndex;
            ClearContent();
            InitializeWidgets();
        }
        else {//finish all questions
            Intent intent = new Intent();
            intent.setClass(this, ReviewActivity.class);
            //save info to intent
            intent.putExtra("id",questionFilter.id);
            intent.putExtra("len",questionFilter.len);
            for(Integer i = 0;i<answerIndexes.size();++i){
                intent.putExtra("answerIndex"+i.toString(),answerIndexes.get(i));
                intent.putExtra("questionName"+i.toString(),questionFilter.questions.get(i).name);
                intent.putExtra("answerName"+i.toString(),questionFilter.questions.get(i).options.get(answerIndexes.get(i)));
            }
            startActivity(intent);
        }
    }
}
