package mg.studio.android.survey;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

final public class ActivityController {
    public static List<Activity> activities = new ArrayList<>();
    //kill all the activities
    public static void Finish(){
        for (Activity activity:activities) {
            activity.finish();
        }
    }
}
