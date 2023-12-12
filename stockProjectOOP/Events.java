package stockProjectOOP;

import java.util.*;

public class Events {
    private List<Event> eventList;
    private static final Random random = new Random();
    private EventListener listener;

    /**
     * Constructor for the Events class.
     * Initializes a new instance of the Events class with an empty list of events.
     */
    public Events() {
        this.eventList = new ArrayList<>();
        initializeEvents();
    }

    /**
     * Initializes and adds predefined events to the event list.
     * 
     * @return none
     */
    private void initializeEvents() {
        eventList.add(new Event("Bitcoin Gone, Like For Real this time", 1.07));
        eventList.add(new Event("Q4 Go Womp Womp", 0.92));
        eventList.add(new Event("Taylor Swift Performs Cruel Summer in NYSE", 1.11));
        eventList.add(new Event("USD Moves to Blockchain", 0.84));
        eventList.add(new Event("Global Warming Stops Warming", 1.09));
        eventList.add(new Event("Q3 Goes BOOM", 1.03));
        eventList.add(new Event("Aliens Refuse to Visit Earth; Cite 'Too Much Drama'", 0.98));
        eventList.add(new Event("Ozempic Becomes Human Right", 1.06));
        eventList.add(new Event("Cat Declared New President of Egypt", 1.03));
        eventList.add(new Event("Bing Chilling Named 2023 Word of Year", 0.90));
        eventList.add(new Event("2024 U.S. Presidential Elections Cancelled", 1.15));
        eventList.add(new Event("Hasan Aljabbouli Named Most Handsome Professor of the Year", 1.18));
        eventList.add(new Event("Declassified NASA documents reveal Moon is made of cheese, dairy industry collapses", 0.92));
        eventList.add(new Event("Garden Gnomes Occupy Wall Street, Demand Equal Rights", 0.85));
        eventList.add(new Event("FBI raids Santa's workshops, finds evidence of slave labor", 0.75));
        eventList.add(new Event("Leonardo DiCaprio returns to star in 'Titanic 2: Revenge of the Ship'", 1.07));
        eventList.add(new Event("International Court of Justice rules in favor of calling it 'football' not 'soccer'", 1.05));
        eventList.add(new Event("Mars Colony Declares Independence", 0.87));
        eventList.add(new Event("Millennials Finally Afford Houses; Real Estate Market in Shambles", 0.86));
        eventList.add(new Event("Scientists Discover China", 1.03));
        eventList.add(new Event("Mark Zuckerberg Sheds Skin for Winter", 1.02));
    }

    /**
     * Applies a random event to a stock and then removes that event from the list.
     * 
     * @param stock The stock to which the event is applied.
     * @return none
     *         //
     */
    public void applyRandomEvent(Stock stock) {
        if (!eventList.isEmpty() && random.nextDouble() < 0.02) { // 2% chance to trigger an event per stock
            int eventIndex = random.nextInt(eventList.size());
            Event selectedEvent = eventList.get(eventIndex);
            stock.simulate(selectedEvent.getImpactFactor());

            if (listener != null) {
                listener.onEventOccured(selectedEvent.getName(), stock);
            }
            // Remove the event from the list
            eventList.remove(eventIndex);
        }
    }

    /**
     * Inner class representing a market event.
     */
    private static class Event {
        private String name;
        private double impactFactor;

        /**
         * Constructor for Event class.
         * 
         * @param name         The name of the event.
         * @param impactFactor The impact factor of the event.
         */
        public Event(String name, double impactFactor) {
            this.name = name;
            this.impactFactor = impactFactor;
        }

        /**
         * Gets the name of the event.
         * 
         * @return The name of the event.
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the impact factor of the event.
         * 
         * @return The impact factor of the event.
         */
        public double getImpactFactor() {
            return impactFactor;
        }
    }
}
