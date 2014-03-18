package learn.deepak.jersey.client;

import learn.deepak.jersey.model.Activity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivityClientTest {

    private final ActivityClient mAC = new ActivityClient();

    @Test
    public void getActivity() {

        Activity a = mAC.getActivity("1");
        System.out.println("Activity 1 : " + a);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getId(), 1);
    }

    @Test
    public void getActivityJson() {

        String jsonResp = mAC.getActivityJson("2");
        System.out.println("json response :\n" + jsonResp);
        Assert.assertNotNull(jsonResp);
    }

    @Test
    public void getActivityXML() {

        String xmlResp = mAC.getActivityXML("1");
        System.out.println("xml response :\n" + xmlResp);
        Assert.assertNotNull(xmlResp);
    }
}
