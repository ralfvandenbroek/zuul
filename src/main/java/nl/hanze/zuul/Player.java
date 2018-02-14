package nl.hanze.zuul;

import java.util.Map;

/**
 * The state of the player in the game.
 * @author Ralf van den Broek
 */
public class Player {
    private Room currentRoom;
    private Map<String, Item> items;
    private int maxWeight = 50;

    /**
     * Create a new player.
     * @param room Starting room.
     */
    public Player(Room room)
    {
        currentRoom = room;
        items = new ItemCollection();
    }

    /**
     * Move the player in a direction.
     * @param direction Direction.
     * @throws IllegalArgumentException If the direction is invalid.
     */
    public void move(String direction) throws IllegalArgumentException
    {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            throw new IllegalArgumentException(direction);
        }
        currentRoom = nextRoom;
    }

    /**
     * Take an item in the current room.
     * @param name Item name.
     * @throws IllegalArgumentException If the item is invalid.
     * @throws LoadTooHeavyException If the player's load would become too high.
     */
    public void take(String name) throws IllegalArgumentException, LoadTooHeavyException
    {
        Item item = currentRoom.getItem(name);

        if (item == null) {
            throw new IllegalArgumentException(name);
        }

        int currentWeight = 0;
        for (String n : items.keySet()) {
            currentWeight += items.get(n).getWeight();
        }
        if (currentWeight + item.getWeight() > maxWeight) {
            throw new LoadTooHeavyException();
        }

        items.put(item.getName(), item);
        currentRoom.removeItem(item);
    }

    /**
     * Drop an item in the current room.
     * @param name Item name.
     * @throws IllegalArgumentException If the item is invalid.
     */
    public void drop(String name) throws IllegalArgumentException
    {
        Item item = items.get(name);

        if (item == null) {
            throw new IllegalArgumentException(name);
        }

        items.remove(item.getName());
        currentRoom.addItem(item);
    }

    /**
     * Look at the current room.
     */
    public void look()
    {
        System.out.println(currentRoom.getLongDescription() + getItemString());
    }

    /**
     * Return a string describing the items the player has.
     * @return Details of the items the player has.
     */
    private String getItemString()
    {
        String returnString = items.toString();
        if (returnString.length() > 0) {
            returnString = "\nYou have " + returnString + ".";
        }
        return returnString;
    }
}
