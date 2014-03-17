package learn.deepak.jersey.repository;

import java.util.List;

import learn.deepak.jersey.model.Activity;
import learn.deepak.jersey.model.User;

public interface ActivityRepository {

    public abstract List<Activity> findAllActivities();

    public abstract Activity findActivity(int aId);

    public abstract User findUser(int aActivityId);

    public abstract void addActivity(Activity aActivity);

}