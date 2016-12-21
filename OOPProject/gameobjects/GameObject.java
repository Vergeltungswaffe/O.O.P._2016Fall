package gameobjects;

public abstract class GameObject
{

    private int row;
    private int col;
    private char icon;

    public GameObject(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public void setIcon(char a)
    {
        icon = a;
    }

    public char getIcon()
    {
        return icon;
    }

    public abstract void showMenu();

    public abstract void inputCommand(Player player, GameObject[][] ent, int row, int col, char command);

}
