package learn.deepak.jersey.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private int    mUserId;
    private String mUserName;

    public User() {
        // no-arg ctor required by JAXB for marshalling/unmarshalling
    }

    public User(int aId, String aName) {

        mUserId = aId;
        mUserName = aName;
    }

    public int getUserId() {
        return mUserId;
    }

    // No setter for Id, so that response does not show the user id

    @XmlElement(name = "name")
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public static int generateUserId() {

        return (int) (System.nanoTime() % 1000000);
    }

    @Override
    public String toString() {

        return "UserId : " + mUserId + " Name : " + mUserName;
    }

}
