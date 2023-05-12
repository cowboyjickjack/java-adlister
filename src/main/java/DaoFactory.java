public class DaoFactory { // separates concerns
    // It's there to serve up the things that you want
    // Like a manager of all the DAOs - if it's not there (if adsDao == null) it'll make one
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao(); // this method is what we're supposed to use
        }
        return adsDao;
    }
}
