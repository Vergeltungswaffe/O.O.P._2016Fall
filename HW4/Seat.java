package OOPhw4;

/*************************************************************************
 * 2016-2 Object Oriented Programming HW4
 * Name: Kim, Jin Seol
 * ID: 2011133024
 * Major: Chemistry
 * Due date: 11/2/2016
 *************************************************************************/

public class Seat
{
    private String name;

    public Seat(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void cancel()
    {
        name = null;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isOccupied()
    {
        return name!=null;
    }

    public boolean match(String targetName)
    {
        return name != null && name.equals(targetName);
    }
}
