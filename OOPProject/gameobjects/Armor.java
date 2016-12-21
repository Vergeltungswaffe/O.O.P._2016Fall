package gameobjects;

import finalPJ.Config;
import gameinterfaces.Equippable;

public class Armor extends Item implements Equippable
{
    private int defence;

    public Armor(int row, int col)
    {
        super(row, col);
        setIcon('A');
        this.defence = Config.ARMOR_DEF;
    }

    @Override
    public void showMenu()
    {
        System.out.println("(E)quip / (N)othing ? : ");
    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {
        if(command=='E')
        {
        	if(player.isHasArmor())
        	{
        		System.out.println("You get the armor.");
                System.out.print("Defence: "+(player.getArmorDefence()+player.getDef())+" -> ");
                equip(player);
                System.out.println(player.getArmorDefence()+player.getDef());
        	}
        	else
        	{
        		System.out.println("You already equipped the armor.");
        	}
            ent[row][col] = new Space(row, col);
        }
        else if(command=='N')
        {
            System.out.println("Do nothing.");
        }
        else
        {
            System.out.println("Invalid input.");
        }
    }

    @Override
    public void equip(Player p)
    {
        p.setHasArmor(true);
        p.setArmorDefence(defence);
        p.setArmorName(Config.ARMOR_NAME);
    }
}