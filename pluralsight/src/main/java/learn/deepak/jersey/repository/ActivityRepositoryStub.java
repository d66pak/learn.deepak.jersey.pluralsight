package learn.deepak.jersey.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import learn.deepak.jersey.model.Activity;
import learn.deepak.jersey.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

    private final ConcurrentMap<Integer, Activity> mActivityRepository = new ConcurrentHashMap<Integer, Activity>(
                                                                               10);

    public ActivityRepositoryStub() {

        // TODO: Hard user id
        User u1 = new User(100, "Matt");
        // TODO: Hard coded id
        Activity a1 = new Activity(1, "Swimming", 55, u1);
        mActivityRepository.put(a1.getId(), a1);

        // TODO: Hard user id
        User u2 = new User(101, "Chan");
        // TODO: Hard coded id
        Activity a2 = new Activity(2, "Cycling", 120, u2);
        mActivityRepository.put(a2.getId(), a2);

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

    @Override
    public void addActivity(Activity aActivity) {

        mActivityRepository.putIfAbsent(aActivity.getId(), aActivity);
    }
}
