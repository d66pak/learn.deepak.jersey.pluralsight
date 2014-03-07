package learn.deepak.jersey.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import learn.deepak.jersey.model.Activity;

public class ActivityRepositoryStub implements ActivityRepository {

    private final Map<Integer, Activity> mActivityRepository = new HashMap<Integer, Activity>(
                                                                     5);

    public ActivityRepositoryStub() {

        Activity a1 = new Activity(1, "Swimming", 55);
        mActivityRepository.put(1, a1);

        Activity a2 = new Activity(2, "Cycling", 120);
        mActivityRepository.put(2, a2);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * learn.deepak.jersey.repository.ActivityRepository#findAllActivities()
     */
    @Override
    public List<Activity> findAllActivities() {

        List<Activity> activityList = new ArrayList<Activity>();

        for (int id : mActivityRepository.keySet()) {

            activityList.add(mActivityRepository.get(id));
        }

        return activityList;
    }

    @Override
    public Activity findActivity(int aId) {

        return mActivityRepository.get(aId);
    }
}
