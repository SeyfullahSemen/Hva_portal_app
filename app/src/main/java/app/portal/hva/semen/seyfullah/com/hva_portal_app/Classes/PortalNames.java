package app.portal.hva.semen.seyfullah.com.hva_portal_app.Classes;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * Created by Seyfullah Semen on 17-9-2018.
 */
public class PortalNames implements Parcelable {

    private String portalName;
    private String url;

    public PortalNames(String portalName, String url) {
        this.portalName = portalName;
        this.url = url;
    }

    public String getPortalName() {
        return portalName;
    }

    public void setPortalName(String portalName) {
        this.portalName = portalName;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.portalName);
        dest.writeString(this.url);
    }


    public PortalNames(Parcel in) {
        this.portalName = in.readString();
        this.url = in.readString();
    }

    public static final Creator<PortalNames> CREATOR = new Creator<PortalNames>() {
        @Override
        public PortalNames createFromParcel(Parcel source) {
            return new PortalNames(source);
        }

        @Override
        public PortalNames[] newArray(int size) {
            return new PortalNames[size];
        }
    };
}
