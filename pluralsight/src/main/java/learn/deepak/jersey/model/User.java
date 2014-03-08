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

    @XmlElement(name = "userId")
    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    @XmlElement(name = "name")
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

}
