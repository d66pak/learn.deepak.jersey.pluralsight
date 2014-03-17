package learn.deepak.jersey.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import learn.deepak.jersey.model.Activity;
import learn.deepak.jersey.model.User;
import learn.deepak.jersey.repository.ActivityRepository;
import learn.deepak.jersey.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityService {

    /**
     * NOTE: For each service new instance of ActivityService is created. Which
     * means, mActivityRepo will not be same for any two requests. Therefore,
     * get call to fetch particular activity by ID would always return null. To
     * overcome this problem single instance of ActivityRepositoryStub must be
     * maintained. For now, activityId is hard coded to 1 and 2 as a hack.
     */
    private ActivityRepository mActivityRepo = new ActivityRepositoryStub();
    private final long         mServiceId    = System.currentTimeMillis();

    public ActivityService() {
        System.out.println("ActivityService : " + mServiceId);
    }

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

        System.out.println("getActivity called with id : " + aId
                + " serviceId : " + mServiceId);
        return mActivityRepo.findActivity(aId);

    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{activityId}/user")
    // 127.0.0.1:8080/pluralsight/webapi/activities/1/user
    public User getUser(@PathParam("activityId") int aId) {

        return mActivityRepo.findUser(aId);
    }
}
