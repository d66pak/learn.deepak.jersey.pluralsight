package learn.deepak.jersey.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import learn.deepak.jersey.model.Activity;
import learn.deepak.jersey.repository.ActivityRepository;
import learn.deepak.jersey.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityService {

    private ActivityRepository mActivityRepo = new ActivityRepositoryStub();

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    // 127.0.0.1:8080/pluralsight/webapi/activities
    public List<Activity> allActivities() {

        return mActivityRepo.findAllActivities();
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{activityId}")
    // 127.0.0.1:8080/pluralsight/webapi/activities/1
    public Activity getActivity(@PathParam("activityId") int aId) {

        return mActivityRepo.findActivity(aId);

    }
}
