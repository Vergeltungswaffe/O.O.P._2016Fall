package gameobjects;

abstract class Unit extends GameObject
{
    private int hp;
    private int maxHp;
    private int atkDmg;
    private int def;

    Unit(int row, int col, int maxHp, int atkDmg, int def)
    {
        super(row, col);
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.atkDmg = atkDmg;
        this.def = def;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public void setMaxHp(int maxhp)
    {
        this.maxHp = maxhp;
    }

    public void setAttackDamage(int atkDmg)
    {
        this.atkDmg = atkDmg;
    }

    public int getAttackDamage()
    {
        return atkDmg;
    }

    public int getDef()
    {
        return def;
    }

    public void setDef(int def)
    {
        this.def = def;
    }

    public abstract void attack(Unit m);


}
