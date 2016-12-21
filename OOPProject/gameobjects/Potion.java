package gameobjects;

import finalPJ.Config;
import gameinterfaces.Consumable;

public class Potion extends Item implements Consumable
{
    private int heal;

    public Potion(int row, int col)
    {
        super(row, col);
        setIcon('P');
        this.heal = Config.POTION_HEAL;
    }

    @Override
    public void showMenu()
    {
        System.out.println("(D)rink / (N)othing ? : ");
    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {
        if(command=='D')
        {
            System.out.println("You drink the potion.");
            consume(player);
            if(player.getHp()>player.getMaxHp())
            {
                player.setHp(player.getMaxHp());
            }
            ent[row][col] = new Space(row, col);
        }
        else if(command=='N')
        {

        }
        else
        {
            System.out.println("Invalid input.");
        }
    }

    @Override
    public void consume(Player p)
    {
        p.setHp(p.getHp()+heal);
    }

}