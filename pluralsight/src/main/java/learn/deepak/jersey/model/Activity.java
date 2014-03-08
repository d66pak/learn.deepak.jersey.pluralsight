package learn.deepak.jersey.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

    private String mDescription;
    private int    mDuration;
    private int    mId;
    private User   mUser;

    public Activity() {
        // no-arg ctor required by JAXB for marshalling/unmarshalling
    }

    public Activity(int aId, String aDesc, int aDurInMins, User aUser) {

        mDescription = aDesc;
        mDuration = aDurInMins;
        mId = aId;
        mUser = aUser;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    @XmlElement(name = "desc")
    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    @XmlElement(name = "dur")
    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    @XmlElement
    public User getUser() {
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
    }

}
