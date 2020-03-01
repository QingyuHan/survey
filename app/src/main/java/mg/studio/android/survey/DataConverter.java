package mg.studio.android.survey;

public final class DataConverter {
    public static int IntToLayoutNum(int num){
        int layoutNum;
        switch (num){
            case 0:
                layoutNum = R.layout.welcome;
                break;
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
                break;
            default:
                throw new NumberFormatException();
        }
        return layoutNum;
    }

    public static int IntToQuestionNum(int num){
        int stringNum;
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
                throw new NumberFormatException();
        }
        return stringNum;
    }

    public  static int IntToCheckBoxNum(int num){
        int checkBoxNum;
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
                throw new NumberFormatException();
        }
        return checkBoxNum;
    }
    public static int IntToAnswerNum(int que,int ans){
        int answerNum;
        switch (que){
            case 1:
            case 8:
                answerNum = IntToPhoneTypeNum(ans);
                break;
            case 2:
                answerNum = IntToCostNum(ans);
                break;
            case 3:
                answerNum = IntToNetNum(ans);
                break;
            case 4:
            case 5:
                answerNum = IntToFuncNum(ans);
                break;
            case 7:
                answerNum = IntToConditionNum(ans);
                break;
            case 9:
                answerNum = IntToCharNum(ans);
                break;
            case 10:
                answerNum = IntToAgeNum(ans);
                break;
            case 11:
                answerNum = IntToGenderNum(ans);
                break;
            case 12:
                answerNum = IntToIncomeNum(ans);
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToPhoneTypeNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.phonetype1;
                break;
            case 2:
                answerNum = R.string.phonetype2;
                break;
            case 3:
                answerNum = R.string.phonetype3;
                break;
            case 4:
                answerNum = R.string.phonetype4;
                break;
            case 5:
                answerNum = R.string.phonetype5;
                break;
            case 6:
                answerNum = R.string.phonetype6;
                break;
            case 7:
                answerNum = R.string.phonetype7;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToGenderNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.gender1;
                break;
            case 2:
                answerNum = R.string.gender2;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToFuncNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.func1;
                break;
            case 2:
                answerNum = R.string.func2;
                break;
            case 3:
                answerNum = R.string.func3;
                break;
            case 4:
                answerNum = R.string.func4;
                break;
            case 5:
                answerNum = R.string.func5;
                break;
            case 6:
                answerNum = R.string.func6;
                break;
            case 7:
                answerNum = R.string.func7;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToIncomeNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.income1;
                break;
            case 2:
                answerNum = R.string.income2;
                break;
            case 3:
                answerNum = R.string.income3;
                break;
            case 4:
                answerNum = R.string.income4;
                break;
            case 5:
                answerNum = R.string.income5;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToCostNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.cost1;
                break;
            case 2:
                answerNum = R.string.cost2;
                break;
            case 3:
                answerNum = R.string.cost3;
                break;
            case 4:
                answerNum = R.string.cost4;
                break;
            case 5:
                answerNum = R.string.cost5;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToConditionNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.condition1;
                break;
            case 2:
                answerNum = R.string.condition2;
                break;
            case 3:
                answerNum = R.string.condition3;
                break;
            case 4:
                answerNum = R.string.condition4;
                break;
            case 5:
                answerNum = R.string.condition5;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToCharNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.char1;
                break;
            case 2:
                answerNum = R.string.char2;
                break;
            case 3:
                answerNum = R.string.char3;
                break;
            case 4:
                answerNum = R.string.char4;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToAgeNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.age1;
                break;
            case 2:
                answerNum = R.string.age2;
                break;
            case 3:
                answerNum = R.string.age3;
                break;
            case 4:
                answerNum = R.string.age4;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
    private static int IntToNetNum(int num){
        int answerNum;
        switch (num){
            case 1:
                answerNum = R.string.net1;
                break;
            case 2:
                answerNum = R.string.net2;
                break;
            case 3:
                answerNum = R.string.net3;
                break;
            case 4:
                answerNum = R.string.net4;
                break;
            default:
                throw new NumberFormatException();
        }
        return answerNum;
    }
}
