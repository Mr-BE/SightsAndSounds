package c.codeblaq.sightsandsounds;

public class Location {
    //Default value for image resources
    private static final int NO_IMAGE_PRESENT = -8;
    /**
     * {@link Location represents a collection of attractions and their locations}
     */
    //Attraction name
    private String mAttractionName;
    //Location name
    private String mLocationName;
    //Attraction Details text
    private String mAtrractionDetails;
    //Primary Image resource for Attraction
    private int mPrimaryImageResource = NO_IMAGE_PRESENT;

    /**
     * Constructor for {@link Location} object with single image
     *
     * @param mAttractionName       is the name of the attraction in the tour guide
     * @param mLocationName         is the place where the attraction can be found
     * @param mPrimaryImageResource is the image to be used in the list view
     */
    public Location(String mAttractionName, String mLocationName, int mPrimaryImageResource) {
        this.mAttractionName = mAttractionName;
        this.mLocationName = mLocationName;
        this.mPrimaryImageResource = mPrimaryImageResource;
    }

    /**
     * Constructor for {@link Location} object with single Image and attraction details
     *
     * @param mAttractionName       is the name of the attraction in the tour guide
     * @param mLocationName         is the place where the attraction can be found
     * @param mPrimaryImageResource is the image to be used in the list view
     * @param mAtrractionDetails    is the detailed description of attraction
     */
    public Location(String mAttractionName, String mLocationName,
                    int mPrimaryImageResource, String mAtrractionDetails) {
        this.mAttractionName = mAttractionName;
        this.mLocationName = mLocationName;
        this.mPrimaryImageResource = mPrimaryImageResource;
        this.mAtrractionDetails = mAtrractionDetails;
    }

    /**
     * Constructor for {@link Location} object with no Image
     * This constructor is used for Lodging list
     *
     * @param mAttractionName is the name of the lodging
     * @param mLocationName   is the location of the lodging
     */
    public Location(String mAttractionName, String mLocationName) {
        this.mAttractionName = mAttractionName;
        this.mLocationName = mLocationName;
    }

    /*Getter methods for the location parameters*/
    //Get attraction name
    public String getmAttractionName() {
        return mAttractionName;
    }

    //Get name of attraction location
    public String getmLocationName() {
        return mLocationName;
    }

    //Get primary Image resource for attraction
    public int getmPrimaryImageResource() {
        return mPrimaryImageResource;
    }

    //Get attraction details for attraction
    public String getmAtrractionDetails() {
        return mAtrractionDetails;
    }

    //Check if image is present
    public boolean hasImage() {
        return mPrimaryImageResource != NO_IMAGE_PRESENT;
    }
}
