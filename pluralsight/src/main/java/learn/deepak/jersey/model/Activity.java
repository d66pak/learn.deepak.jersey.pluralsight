package learn.deepak.jersey.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

    private String mDescription;
    private int    mDuration;
    private int    mId;

    public Activity() {
    }

    public Activity(int aId, String aDesc, int aDurInMins) {

        mDescription = aDesc;
        mDuration = aDurInMins;
        mId = aId;
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

}
