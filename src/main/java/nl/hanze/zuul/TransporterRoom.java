package nl.hanze.zuul;

import java.util.Random;

/**
 * A transporter room with random exits.
 * @author Ralf van den Broek
 */
public class TransporterRoom extends Room {
    private Room[] rooms;
    private Random random;

    /**
     * Create a new transporter room.
     * @param description Room description.
     * @param rooms Possible exits.
     */
    public TransporterRoom(String description, Room[] rooms)
    {
        super(description);
        // fake an exit to show to the user
        setExit("transporter", this);
        this.rooms = rooms;
        random = new Random();
    }

    @Override
    public Room getExit(String direction) {
        // always return a random room
        return rooms[random.nextInt(rooms.length)];
    }
}
