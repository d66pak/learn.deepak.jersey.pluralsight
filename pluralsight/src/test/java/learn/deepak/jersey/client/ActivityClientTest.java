package learn.deepak.jersey.client;

import java.util.List;

import learn.deepak.jersey.model.Activity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivityClientTest {

    private final ActivityClient mAC = new ActivityClient();

    @Test
    public void getActivity() {

        Activity a = mAC.get("1");
        System.out.println("Activity 1 : " + a);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getId(), 1);
    }

    @Test
    public void getActivityList() {

        List<Activity> actList = mAC.get();
        Assert.assertEquals(actList.size(), 2);
    }

    @Test
    public void getActivityJson() {

        String jsonResp = mAC.getJson("2");
        System.out.println("json response :\n" + jsonResp);
        Assert.assertNotNull(jsonResp);
    }

    @Test
    public void getActivityListJson() {

        String activities = mAC.getJson();
        System.out.println("activities in json format :\n" + activities);
        Assert.assertNotNull(activities);
    }

    @Test
    public void getActivityXML() {

        String xmlResp = mAC.getXML("1");
        System.out.println("xml response :\n" + xmlResp);
        Assert.assertNotNull(xmlResp);
    }
}
