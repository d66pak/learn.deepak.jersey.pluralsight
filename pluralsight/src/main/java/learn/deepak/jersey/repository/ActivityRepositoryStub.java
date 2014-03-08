package learn.deepak.jersey.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import learn.deepak.jersey.model.Activity;
import learn.deepak.jersey.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

    private final Map<Integer, Activity> mActivityRepository = new HashMap<Integer, Activity>(
                                                                     5);

    public ActivityRepositoryStub() {

        User u1 = new User(201, "Matt");
        Activity a1 = new Activity(1, "Swimming", 55, u1);
        mActivityRepository.put(1, a1);

        User u2 = new User(202, "Chan");
        Activity a2 = new Activity(2, "Cycling", 120, u2);
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

        Activity a = mActivityRepository.get(aId);
        return a;
    }

    @Override
    public User findUser(int aActivityId) {

        User u = null;
        Activity a = mActivityRepository.get(aActivityId);
        if (a != null) {

            u = a.getUser();
        }
        return u;
    }
}
