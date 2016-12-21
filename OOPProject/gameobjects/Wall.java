package gameobjects;

public class Wall extends Obstacle
{
    public Wall(int row, int col)
    {
        super(row, col);
        setIcon('#');
    }

    @Override
    public void showMenu()
    {

    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {

    }

}
