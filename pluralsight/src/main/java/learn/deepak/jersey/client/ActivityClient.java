/**
 * 
 */
package learn.deepak.jersey.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import learn.deepak.jersey.model.Activity;

/**
 * @author dtelkar
 * 
 */
public class ActivityClient {

    private Client mClient;

    public ActivityClient() {

        mClient = ClientBuilder.newClient();
    }

    public Activity get(String aId) {

        WebTarget target = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/");
        Activity a = target.path("activities/").path(aId).request()
                .get(Activity.class);
        return a;
    }

    public List<Activity> get() {

        List<Activity> activities = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/activities")
                .request().get(new GenericType<List<Activity>>() {
                });

        return activities;
    }

    public String getXML(String aId) {

        WebTarget target = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/");
        String xmlResp = target.path("activities/").path(aId).request()
                .get(String.class);
        return xmlResp;
    }

    public String getXML() {

        return mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/activities")
                .request().get(String.class);
    }

    public String getJson(String aId) {

        WebTarget target = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/");
        Response resp = target.path("activities/").path(aId)
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        System.out.println("getActivityJson status : " + resp);
        return resp.readEntity(String.class);
    }

    public String getJson() {

        Response resp = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/activities")
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        return resp.readEntity(String.class);
    }

    public Response create(Activity a) {

        return mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/activities/activity")
                .request()
                .post(Entity.entity(a, MediaType.APPLICATION_JSON_TYPE));
    }
}
