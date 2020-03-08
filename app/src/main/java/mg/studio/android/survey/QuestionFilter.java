package mg.studio.android.survey;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//load sample json to classes
public class QuestionFilter {
    public int id = 0;
    public int len = 0;
    public List<Question> questions = new ArrayList<Question>();
    public QuestionFilter(String jsonStr, Context context){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonStr);
            jsonObject = jsonObject.getJSONObject("survey");
            id = jsonObject.getInt("id");
            len = jsonObject.getInt("len");
            JSONArray questionArray = jsonObject.getJSONArray("questions");
            for(int i = 0;i<len;++i){
                jsonObject = questionArray.getJSONObject(i);
                Question question = new Question();
                question.name = jsonObject.getString("question");
                question.type = StrToQuestionType(jsonObject.getString("type"));
                JSONArray optionArray = jsonObject.getJSONArray("options");
                for(int j = 0;j<optionArray.length();++j){
                    jsonObject = optionArray.getJSONObject(j);
                    question.options.add(jsonObject.getString(((Integer)(j+1)).toString()));
                }
                questions.add(question);
            }

        }
        catch (Exception e){
            Toast toast=Toast.makeText(context,e.toString(),Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
    }
    public class Question{
        public QuestionType type = QuestionType.single;
        public List<String> options = new ArrayList<String>();
        public String name = "";
    }
    //single type only in this version
    enum QuestionType{
        single
    }

    public static QuestionType StrToQuestionType(String str) throws Exception {
        switch (str){
            case "single":
                return QuestionType.single;
            default:
                throw new Exception("wrong type");
        }
    }
}

