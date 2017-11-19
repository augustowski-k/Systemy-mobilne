package proj.sm.systemymobilne.Repositories;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.List;

/**
 * Created by augus on 11/19/2017.
 */

public class XmlCountryRepository implements ICountriesRepository{

    @Override
    public List<String> getCountryNames() {
        XmlPullParser parser = getXmlParser();

        return null;
    }

    private XmlPullParser getXmlParser(){
        try {
            XmlPullParserFactory pullParserFactory;
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            return parser;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return null;
        }
    }
}
