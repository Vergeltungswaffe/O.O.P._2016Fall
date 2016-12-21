package finalPJ;

import gameinterfaces.Movable;
import gameobjects.*;
import java.util.*;

public class WorldMap
{
    private GameObject[][] worldMap;
    private Scanner scan;
    private Player player;
    private int mapRows;
    private int mapCols;

    private FileManager fm;

    public WorldMap()
    {
        scan = new Scanner(System.in);
    }

    public void linkFileManager(FileManager f)
    {
        this.fm = f;
        f.getCharMap();
    }

    public GameObject[][] getWorldMap()
    {
        return worldMap;
    }

    public Player getPlayer()
    {
        return player;
    }

    public int getMapRows()
    {
        return mapRows;
    }

    public int getMapCols()
    {
        return mapCols;
    }

    public void initialize(char[][] map)
    {
        mapRows = map.length;
        mapCols = map[0].length;
        worldMap = new GameObject[mapRows][];
        int isPlayerOnlyOne = 0;
        for(int i=0;i<mapRows;i++)
        {
            worldMap[i] = new GameObject[mapCols];
            for(int j=0;j<mapCols;j++)
            {
                switch(map[i][j])
                {
                    case '@':
                        if(isPlayerOnlyOne>=1)
                        {
                            System.out.println("$$Only one player is allowed. Check map data.");
                            return;
                        }
                        worldMap[i][j] = new Player(i,j);
                        player = (Player) worldMap[i][j];
                        isPlayerOnlyOne++;
                        break;
                    case '#':
                        worldMap[i][j] = new Wall(i,j);
                        break;
                    case 'R':
                        worldMap[i][j] = new Rock(i,j);
                        break;
                    case 'P':
                        worldMap[i][j] = new Potion(i,j);
                        break;
                    case 'M':
                        worldMap[i][j] = new Monster(i,j);
                        break;
                    case 'W':
                        worldMap[i][j] = new Weapon(i,j);
                        break;
                    case 'A':
                        worldMap[i][j] = new Armor(i,j);
                        break;
                    case '.':
                        worldMap[i][j] = new Space(i,j);
                        break;
                    default:
                        System.out.println("$$There are invalid objects. Check map data.");
                        return;
                }
            }
        }
    }

    public void run()
    {
        printMap();
        printPlayerInfo();
        System.out.println("(A):Left (D):Right (W):Up (S):Down (M):Menu");
        char select = charScan();
        while(true)
        {
            switch(select)
            {
                case 'M':
                    System.out.println("(S):Save (L):Load (Q):Quit (R):Return");
                    boolean backFlag = false;
                    while(!backFlag)
                    {
                        char menuSelect = charScan();
                        switch (menuSelect)
                        {
                            case 'S':
                                fm.save();
                                System.out.println("(S):Save (L):Load (Q):Quit (R):Return");
                                break;
                            case 'L':
                                fm.load();
                                System.out.println("(S):Save (L):Load (Q):Quit (R):Return");
                                break;
                            case 'Q':
                                return;
                            case 'R':
                                backFlag = true;
                                break;
                            default:
                                System.out.println("$$Invalid Input.");
                        }

                    }
                    break;
                case 'A':
                    move(player, 'a');
                    break;
                case 'D':
                    move(player, 'd');
                    break;
                case 'W':
                    move(player, 'w');
                    break;
                case 'S':
                    move(player, 's');
                    break;
                default:
                    System.out.println("$$Invalid Input.");
            }
            if(player.getHp()<=0)
            {
                System.out.println("You died.");
                return;
            }
            printMap();
            printPlayerInfo();
            System.out.println("(A):Left (D):Right (W):Up (S):Down (M):Menu");
            select = charScan();
        }
    }

    public void printMap()
    {
        for(int i=0;i<worldMap.length;i++)
        {
            for(int j=0;j<worldMap[0].length;j++)
            {
                System.out.print(worldMap[i][j].getIcon());
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printPlayerInfo()
    {
        System.out.println("Player\tHP: "+player.getHp()+"/"+player.getMaxHp()+
           "\tDamage: "+(player.getAttackDamage()+player.getWeaponDamage())+
           "\tDefence: "+(player.getDef()+player.getArmorDefence()));
        System.out.println("\t"+player.getWeaponName()+"\t"+player.getArmorName());
        System.out.println("\tX: "+player.getCol()+"\tY: "+player.getRow());
        System.out.println();
    }

    private char charScan()
    {
        System.out.print(">>Select: ");
        String myInput = scan.next();
        while(myInput.length()>1)
        {
            System.out.println("$$Invalid input.");
            System.out.print(">>Select: ");
            myInput = scan.next();
        }
        return myInput.toUpperCase().charAt(0);
    }

    private <T extends GameObject> void move(T obj, char direction) //a d w s
    {
        if(!(obj instanceof Movable))
            return;
        int row = obj.getRow();
        int col = obj.getCol();
        //left
        if(direction=='a')
        {
            if(col==0)
                return;
            worldMap[row][col-1].showMenu();
            if(worldMap[row][col-1] instanceof Wall||worldMap[row][col-1] instanceof Space)
            {
                worldMap[row][col - 1].inputCommand(player, worldMap, row, col-1, ' ');
            }
            else
            {
                worldMap[row][col-1].inputCommand(player, worldMap, row, col-1, charScan());
            }
        }
        //right
        else if(direction=='d')
        {
            if(col==mapCols-1)
                return;
            worldMap[row][col+1].showMenu();
            if(worldMap[row][col+1] instanceof Wall||worldMap[row][col+1] instanceof Space)
            {
                worldMap[row][col + 1].inputCommand(player, worldMap, row, col+1, ' ');
            }
            else
            {
                worldMap[row][col + 1].inputCommand(player, worldMap, row, col+1, charScan());
            }
        }
        //up
        else if(direction=='w')
        {
            if(row==0)
                return;
            worldMap[row-1][col].showMenu();
            if(worldMap[row-1][col] instanceof Wall||worldMap[row-1][col] instanceof Space)
            {
                worldMap[row-1][col].inputCommand(player, worldMap, row-1, col, ' ');
            }
            else
            {
                worldMap[row - 1][col].inputCommand(player, worldMap, row-1, col, charScan());
            }
        }
        //down
        else if(direction=='s')
        {
            if(row==mapRows-1)
                return;
            worldMap[row+1][col].showMenu();
            if(worldMap[row+1][col] instanceof Wall||worldMap[row+1][col] instanceof Space)
            {
                worldMap[row+1][col].inputCommand(player, worldMap, row+1, col, ' ');
            }
            else
            {
                worldMap[row + 1][col].inputCommand(player, worldMap, row+1, col, charScan());
            }
        }
    }
}
