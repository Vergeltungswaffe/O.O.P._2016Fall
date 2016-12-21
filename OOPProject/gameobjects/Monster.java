package gameobjects;

import finalPJ.Config;

public class Monster extends Unit
{

    public Monster(int row, int col)
    {
        super(row, col, Config.MONSTER_MAX_HP, Config.MONSTER_INITIAL_ATK_DMG, Config.MONSTER_INITIAL_DEF);
        setIcon('M');
    }

    @Override
    public void showMenu()
    {
        System.out.print("(A)ttack / (L)eave ? : ");
    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {
        if(command=='A')
        {
            player.attack(this);
            if(this.getHp()<=0)
            {
                System.out.println("Victory!");
                ent[row][col] = new Space(row, col);
                return;
            }
            attack(player);
        }
        else if(command=='L')
        {
            System.out.println("You fled from the monster");
        }
        else
        {
            System.out.println("Invalid input.");
        }
    }

    @Override
    public void attack(Unit m)
    {
        m.setHp(m.getHp()-this.getAttackDamage()+((Player)m).totalDef());
        if(m.getHp()<=0)
        {
            m.setHp(0);
        }
        System.out.println("The monster attacked you!");
        System.out.println("You have "+(Config.MONSTER_INITIAL_ATK_DMG-((Player)m).totalDef())+" damages.");
    }
}