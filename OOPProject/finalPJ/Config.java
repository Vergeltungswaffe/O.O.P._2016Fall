package finalPJ;

public class Config
{
	//File path
    public static final String MAPDATA_PATH = "c:\\oop\\map.dat";
    public static final String MAPSAVE_PATH = "c:\\oop\\map_save.dat";
    public static final String UNITSAVE_PATH = "c:\\oop\\unit_save.dat";

    //Player info
    public static final int PLAYER_MAX_HP = 200;
    public static final int PLAYER_INITIAL_ATK_DMG = 50;
    public static final int PLAYER_INITIAL_DEF = 0;

    //Monster info
    public static final int MONSTER_MAX_HP = 80;
    public static final int MONSTER_INITIAL_ATK_DMG = 40;
    public static final int MONSTER_INITIAL_DEF = 0;

    //Armor info
    public static final String ARMOR_NAME = "Superior armor";
    public static final int ARMOR_DEF = 20;

    //Weapon info
    public static final String WEAPON_NAME = "Giant sword";
    public static final int WEAPON_DAMAGE = 30;

    //Potion info
    public static final int POTION_HEAL = 70;

    //For visual
    public static void printOpenCredit()
    {
        System.out.println("+-------------------------------+");
        System.out.println("| 2016 Autumn OOP Final Project |");
        System.out.println("|                               |");
        System.out.println("|  Made by Se-Woong & Jin-Seol  |");
        System.out.println("+-------------------------------+\n");
    }

    public static void printEndCredit()
    {
        System.out.println("\n+-------------------------------+");
        System.out.println("|          GAME   OVER          |");
        System.out.println("|                               |");
        System.out.println("|       Thanks For Playing      |");
        System.out.println("|                               |");
        System.out.println("|  Made by Se-Woong & Jin-Seol  |");
        System.out.println("+-------------------------------+");
    }
}