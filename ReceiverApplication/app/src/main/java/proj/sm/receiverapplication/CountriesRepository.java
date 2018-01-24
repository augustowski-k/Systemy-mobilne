package proj.sm.receiverapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by augus on 12/14/2017.
 */

public class CountriesRepository implements ICountriesRepository {
    private final String[] COUNTRIES =
            {
                    "Polska", "Niemcy", "Szkocja",
                    "Wielka Brytania", "Argentyna",
                    "Ukraina", "Azerbajdżan", "Pakistan",
                    "Panama", "Gruzja", "Uzbekistan",
                    "Francja", "Malta", "Turcja"
            };

    @Override
    public List<String> getCountryNames() {
        List<String> countryNames = new ArrayList<>();
        for (String countryName: COUNTRIES) {
            countryNames.add(countryName);
        }
        return countryNames;
    }
}
