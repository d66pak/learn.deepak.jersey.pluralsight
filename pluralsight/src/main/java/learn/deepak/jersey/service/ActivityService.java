package learn.deepak.jersey.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
    public Response getUser(@PathParam("activityId") int aId) {

        if (aId < 0) {

            return Response.status(Status.BAD_REQUEST)
                    .entity("Activity Id cannot be less that zero!").build();
        }

        User u = mActivityRepo.findUser(aId);
        if (u == null) {

            throw new WebApplicationException(Response.status(Status.NOT_FOUND)
                    .entity("No user found in activity id : " + aId).build());
        }

        return Response.ok(u).build();
    }

    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
    @Path("activity")
    // 127.0.0.1:8080/pluralsight/webapi/activities/activity
    public Activity addActivity(MultivaluedMap<String, String> aFormParams) {

        String desc = aFormParams.getFirst("desc");
        String dur = aFormParams.getFirst("dur");
        String user = aFormParams.getFirst("user");
        System.out.println("Description : " + desc + " Duration : " + dur
                + " User : " + user);

        // TODO: Hard user id
        User u = new User(103, ((user == null) ? "default" : user));
        Activity a = new Activity(3, desc, Integer.parseInt(dur), u);
        mActivityRepo.addActivity(a);
        return a;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("activity")
    // 127.0.0.1:8080/pluralsight/webapi/activities/activity
    public Response addActivityBinding(Activity activity) {

        System.out.println(activity.toString());

        // Create activity with proper ids
        // TODO : Hardcoded ids
        User u = new User(104, activity.getUser().getUserName());
        Activity a = new Activity(4, activity.getDescription(),
                activity.getDuration(), u);
        mActivityRepo.addActivity(a);
        return Response.ok(a).build();
    }

}
