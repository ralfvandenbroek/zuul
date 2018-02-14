package nl.hanze.zuul;

import java.util.HashMap;

/**
 * A collection of items.
 * @author Ralf van den Broek
 */
public class ItemCollection extends HashMap<String, Item>
{
    @Override
    public String toString()
    {
        // render the item list using the item descriptions
        String returnString = "";
        int i = 0;
        for (String name : keySet())
        {
            Item item = get(name);
            returnString += item.getDescription();
            i++;
            if (i == size() - 1) {
                returnString += " and ";
            } else if (i < size()) {
                returnString += ", ";
            }
        }
        return returnString;
    }
}
