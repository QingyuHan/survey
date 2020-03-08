package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        InitializeWidgets();
    }
    //show questions and answers
    private void InitializeWidgets(){
        TextView textView = findViewById(R.id.answerView);
        StringBuilder string = new StringBuilder();
        int length = getIntent().getIntExtra("len",0);
        for(Integer i = 0;i<length;++i){
            string.append("QUESTION ").append(i+1).append(":");
            string.append(getIntent().getStringExtra("questionName"+i.toString()));
            string.append("\n    ");
            string.append(getIntent().getStringExtra("answerName"+i.toString()));
            string.append("\n\n");
        }
        textView.setText(string);
    }
    //load answer from intent, then convert to jsonObject
    private JSONObject LoadAnswerToJSON(){
        JSONObject allData = new JSONObject();
        int length = getIntent().getIntExtra("len",0);
        int id = getIntent().getIntExtra("id",0);
        try {
            allData.put("id",id);
            allData.put("len",length);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date(System.currentTimeMillis());
            allData.put("time",simpleDateFormat.format(date));
            JSONArray array = new JSONArray();
            for (Integer i = 0;i<length;++i){
                array.put(getIntent().getIntExtra("answerIndex"+i.toString(),0));
            }
            allData.put("answers",array);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return allData;
    }
    //append string to file
    private void SaveToStorage(String data,String path,String fileName){
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
            //append to old file
            FileWriter writer = new FileWriter(file,true);
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            Toast toast=Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
    }
    //save all the answers
    private void SaveAnswer(){
        JSONObject allData = LoadAnswerToJSON();
        //get SDCard's state
        String en = Environment.getExternalStorageState();
        if (en.equals(Environment.MEDIA_MOUNTED)) {
            String fileName = "result";
            String path = getExternalFilesDir(null).getAbsolutePath();
            //package dir
            SaveToStorage(allData.toString(),path,fileName+".json");
            SaveToStorage(allData.toString(),path,fileName+".txt");//convenient to read
            //shared dir
            //SaveToStorage(allData.toString(),Environment.getExternalStorageDirectory().getAbsolutePath(),fileName+".json");
        } else {
            Toast toast=Toast.makeText(this,"SD card missing",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
    public void NextButtonDown(View view){
        SaveAnswer();
        Intent intent =  new Intent();
        intent.setClass(this, FinishActivity.class);
        startActivity(intent);
    }
}
