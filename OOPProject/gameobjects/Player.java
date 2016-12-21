package gameobjects;

import finalPJ.Config;
import gameinterfaces.Movable;

public class Player extends Unit implements Movable
{
    private boolean hasArmor;
    private boolean hasWeapon;
    private int armorDefence;
    private int weaponDamage;
    private String weaponName;
    private String armorName;

    public Player(int row, int col)
    {
        super(row, col, Config.PLAYER_MAX_HP, Config.PLAYER_INITIAL_ATK_DMG, Config.PLAYER_INITIAL_DEF);
        setIcon('@');
        hasArmor = false;
        hasWeapon = false;
        armorDefence =0;
        armorName = "Naked";
        weaponDamage =0;
        weaponName = "Bare hands";
    }

    @Override
    public void showMenu()
    {

    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {

    }

    @Override
    public void attack(Unit m)
    {
        m.setHp(m.getHp()-this.totalDmg()+m.getDef());
        if(m.getHp()<=0)
        {
            m.setHp(0);
        }
        System.out.println("You attacked the monster!");
        System.out.println("You attack "+(totalDmg()-m.getDef())+" damages.");
        System.out.println("The monster's HP: "+m.getHp()+"/"+m.getMaxHp());
    }

    @Override
    public void moveTo(GameObject[][] ent, int row, int col)
    {
        int beforeRow = getRow();
        int beforeCol = getCol();
        ent[row][col] = this; //Upcasting
        setRow(row);
        setCol(col);
        ent[beforeRow][beforeCol] = new Space(beforeRow, beforeCol); //Upcasting
    }

    public void setArmorDefence(int def)
    {
        this.armorDefence = def;
    }

    public int getArmorDefence()
    {
        return this.armorDefence;
    }

    public void setWeaponDamage(int dmg)
    {
        this.weaponDamage = dmg;
    }

    public int getWeaponDamage()
    {
        return this.weaponDamage;
    }

    public int totalDmg()
    {
        return this.getAttackDamage()+weaponDamage;
    }

    public int totalDef()
    {
        return this.getDef()+armorDefence;
    }

    public String getWeaponName()
    {
        return weaponName;
    }

    public void setWeaponName(String weaponName)
    {
        this.weaponName = weaponName;
    }

    public String getArmorName()
    {
        return armorName;
    }

    public void setArmorName(String armorName)
    {
        this.armorName = armorName;
    }

    public boolean isHasArmor()
    {
        return hasArmor;
    }

    public void setHasArmor(boolean hasArmor)
    {
        this.hasArmor = hasArmor;
    }

    public boolean isHasWeapon()
    {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon)
    {
        this.hasWeapon = hasWeapon;
    }
}