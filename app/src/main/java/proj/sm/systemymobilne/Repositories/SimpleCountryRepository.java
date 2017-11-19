package proj.sm.systemymobilne.Repositories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by augus on 11/19/2017.
 */

public class SimpleCountryRepository implements ICountriesRepository {
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
