package nl.hanze.zuul;

/**
 * An item in an adventure game.
 * @author Ralf van den Broek
 */
public class Item {
    private String name;
    private String description;
    private int weight;

    /**
     * Create a new item.
     * @param name Short item name used in commands.
     * @param description Long item description.
     * @param weight Item weight.
     */
    public Item(String name, String description, int weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    /**
     * Get item name.
     * @return Item name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get item description.
     * @return Item description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Get item weight.
     * @return Item weight.
     */
    public int getWeight()
    {
        return weight;
    }
}
