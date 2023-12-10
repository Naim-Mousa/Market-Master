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
        eventList.add(new Event("Taylor Swift Visits NYSE", 1.11));
        eventList.add(new Event("USD Moves to Blockchain", 0.64));
        eventList.add(new Event("Global Warming Stops Warming", 1.09));
        eventList.add(new Event("Q3 Goes BOOM", 1.03));
        eventList.add(new Event("Ozempic Becomes Human Right", 1.06));
        eventList.add(new Event("Bing Chilling Named 2023 Word of Year", 0.90));
    }

    /**
     * Sets the event listener.
     * 
     * @param listener The event listener.
     * @return none
     */
    public void setEventListener(EventListener listener) {
        this.listener = listener;
    }

    /**
     * Applies a random event to a stock and then removes that event from the list.
     * 
     * @param stock The stock to which the event is applied.
     * @return none
     */
    public void applyRandomEvent(Stock stock) {
        if (!eventList.isEmpty() && random.nextDouble() < 0.04) { // 4% chance to trigger an event per stock
            int eventIndex = random.nextInt(eventList.size());
            Event selectedEvent = eventList.get(eventIndex);
            stock.simulate(selectedEvent.getImpactFactor());
            // System.out.println("BREAKING NEWS: " + selectedEvent.getName() + " on " + stock.getStockName());
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