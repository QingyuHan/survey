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
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static mg.studio.android.survey.DataConverter.IntToLayoutNum;

public class ReviewActivity extends AppCompatActivity {
    private int layoutNum = 13;
    private Class nextActivity = FinishActivity.class;
    private String[] answers = new String[13];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityController.activities.add(this);
        super.onCreate(savedInstanceState);
        LoadAnswers();
        setContentView(IntToLayoutNum(layoutNum));
        InitializeWidgets();
    }
    private void InitializeWidgets(){
        TextView textView = findViewById(R.id.textView1);
        String string = new String("");
        for (int i = 1;i<13;++i){
            string+= getResources().getString(DataConverter.IntToQuestionNum(i));
            string+="\n    ";
            string+=answers[i];
            string+="\n\n";
        }
        textView.setText(string);
    }
    private void LoadAnswers(){
        for (Integer i =1;i<13;++i){
            answers[i] = getIntent().getStringExtra("answer"+i.toString());
        }
    }
    private void SaveAnswers(){
        SaveToStorage();
    }

    private void SaveToStorage(){
        JSONObject allData = new JSONObject();
        for (Integer i = 1;i<13;++i){
            try {
                allData.put("question"+i.toString(),answers[i]);
            }
            catch (JSONException  e){
                e.printStackTrace();
            }
        }
        //获取SDCard状态,如果SDCard插入了手机且为非写保护状态
        String en = Environment.getExternalStorageState();
        if (en.equals(Environment.MEDIA_MOUNTED)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date(System.currentTimeMillis());
            String fileName = simpleDateFormat.format(date)+".txt";
            String path = getExternalFilesDir(null).getAbsolutePath();
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
                        Toast toast=Toast.makeText(this,"创建失败",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return;
                    }
                }
                PrintStream out=new PrintStream(new FileOutputStream(file));  //实例化打印流对象
                out.print(allData.toString());     //输出数据
                out.close();
            } catch (Exception e) {
                Toast toast=Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
        } else {
            //提示用户SDCard不存在或者为写保护状态
            Toast toast=Toast.makeText(this,"SD card missing",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
    public void NextButtonDown(View view){
        SaveAnswers();
        Intent intent =  new Intent();
        intent.setClass(this, nextActivity);
        startActivity(intent);
    }
}
