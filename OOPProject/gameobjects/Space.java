package gameobjects;

public class Space extends GameObject
{
    public Space(int row, int col)
    {
        super(row, col);
        setIcon('.');
    }

    @Override
    public void showMenu()
    {

    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {
        player.moveTo(ent, row, col);
    }

}
