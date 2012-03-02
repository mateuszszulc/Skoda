package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 02.03.12
 * Time: 19:25
 */
public class EventManager {
    private List<BCEvents> registeredBCEvents;

    public EventManager() {
        this.registeredBCEvents = new ArrayList<BCEvents>();
    }

    public void add(BCEvents stationInfoChanged) {
        registeredBCEvents.add(stationInfoChanged);
    }

    public void deleteAllRegisteredEvents() {
        registeredBCEvents.clear();
    }

}
