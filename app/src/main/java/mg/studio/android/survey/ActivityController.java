package mg.studio.android.survey;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

final public class ActivityController {
    public static List<Activity> activities = new ArrayList<>();
    public static void Finish(){
        for (Activity activity:activities) {
            activity.finish();
        }
    }
    public static int IntToLayoutNum(int num){
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
                layoutNum = R.layout.activity_review;
                break;
            case 14:
                layoutNum = R.layout.finish_survey;
            default:
                break;
        }
        return layoutNum;
    }
    public static int IntToQuestionNum(int num){
        int stringNum = R.string.question1;
        switch (num){
            case 1:
                stringNum = R.string.question1;
                break;
            case 2:
                stringNum = R.string.question2;
                break;
            case 3:
                stringNum = R.string.question3;
                break;
            case 4:
                stringNum = R.string.question4;
                break;
            case 5:
                stringNum = R.string.question5;
                break;
            case 6:
                stringNum = R.string.question6;
                break;
            case 7:
                stringNum = R.string.question7;
                break;
            case 8:
                stringNum =R.string.question8;
                break;
            case 9:
                stringNum =R.string.question9;
                break;
            case 10:
                stringNum = R.string.question10;
                break;
            case 11:
                stringNum = R.string.question11;
                break;
            case 12:
                stringNum = R.string.question12;
                break;
            default:
                break;
        }
        return stringNum;
    }
    public  static int IntToCheckBoxNum(int num){
        int checkBoxNum = R.id.checkBox1;
        switch (num){
            case 1:
                checkBoxNum = R.id.checkBox1;
                break;
            case 2:
                checkBoxNum = R.id.checkBox2;
                break;
            case 3:
                checkBoxNum = R.id.checkBox3;
                break;
            case 4:
                checkBoxNum =R.id.checkBox4;
                break;
            case 5:
                checkBoxNum = R.id.checkBox5;
                break;
            case 6:
                checkBoxNum = R.id.checkBox6;
                break;
            case 7:
                checkBoxNum = R.id.checkBox7;
                break;
            default:
                break;
        }
        return checkBoxNum;
    }
}
