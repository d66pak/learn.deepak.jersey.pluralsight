/**
 * 
 */
package learn.deepak.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
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

    public Activity getActivity(String aId) {

        WebTarget target = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/");
        Activity a = target.path("activities/").path(aId).request()
                .get(Activity.class);
        return a;
    }

    public String getActivityXML(String aId) {

        WebTarget target = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/");
        String xmlResp = target.path("activities/").path(aId).request()
                .get(String.class);
        return xmlResp;
    }

    public String getActivityJson(String aId) {

        WebTarget target = mClient
                .target("http://127.0.0.1:8080/pluralsight/webapi/");
        Response resp = target.path("activities/").path(aId)
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        System.out.println("getActivityJson status : " + resp);
        return resp.readEntity(String.class);
    }
}
