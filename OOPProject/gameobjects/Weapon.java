package gameobjects;

import finalPJ.Config;
import gameinterfaces.Equippable;

public class Weapon extends Item implements Equippable
{
    private int damage;

    public Weapon(int row, int col)
    {
        super(row, col);
        setIcon('W');
        this.damage = Config.WEAPON_DAMAGE;
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
        	if(!player.isHasWeapon())
        	{
                System.out.println("You get the weapon.");
                System.out.print("Damage: "+(player.getWeaponDamage()+player.getAttackDamage())+" -> ");
                equip(player);
                System.out.println(player.getWeaponDamage()+player.getAttackDamage());
        	}
        	else
        	{
        		System.out.println("You already equipped the weapon.");
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
        p.setHasWeapon(true);
        p.setWeaponDamage(damage);
        p.setWeaponName(Config.WEAPON_NAME);
    }
}
