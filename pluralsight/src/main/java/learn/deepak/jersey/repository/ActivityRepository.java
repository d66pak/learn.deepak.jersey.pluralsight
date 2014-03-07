package learn.deepak.jersey.repository;

import java.util.List;

import learn.deepak.jersey.model.Activity;

public interface ActivityRepository {

    public abstract List<Activity> findAllActivities();

    public abstract Activity findActivity(int aId);

}