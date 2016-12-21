package finalPJ;

import gameobjects.GameObject;
import gameobjects.Monster;
import gameobjects.Player;
import java.io.*;
import java.util.*;

public class FileManager
{

    private char[][] map;
    private File mapDataFile;
    private File mapSaveFile;
    private File unitSaveFile;
    private BufferedReader br;
    private BufferedOutputStream bo;
    private BufferedWriter bw;
    private BufferedInputStream bi;

    private WorldMap worldMap;
    private Player player;

    public FileManager()
    {
        mapDataFile = new File(Config.MAPDATA_PATH);
        try
        {
            br = new BufferedReader(new FileReader(mapDataFile));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }

    public char[][] buildMap()
    {
        System.out.println(">>Initializing map...");
        try
        {
            ArrayList<char[]> mapTemp = new ArrayList<>();
            String temp = br.readLine();
            int numColumn = temp.length();
            mapTemp.add(temp.toCharArray());
            while(br.ready())
            {
                temp = br.readLine();
                if(numColumn!=temp.length())
                {
                    System.out.println("$$Invalid map shape.");
                    return null;
                }
                mapTemp.add(temp.toCharArray());
            }
            if(mapTemp.size()==1)
            {
                System.out.println("$$Invalid map shape.");
                return null;
            }
            map = new char[mapTemp.size()][mapTemp.get(0).length];
            for(int i=0;i<mapTemp.size();i++)
            {
                map[i] = mapTemp.get(i);
            }
            System.out.println(">>Map initializing complete.\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return map;
    }

    public void save()
    {
        System.out.println(">>Saving objects...");
        try
        {
            //Object position
            worldMapToChar();
            mapSaveFile = new File(Config.MAPSAVE_PATH);
            bw = new BufferedWriter(new FileWriter(mapSaveFile));
            for (char[] mapLine : map)
            {
                bw.write(mapLine);
                bw.newLine();
            }

            //Unit status
            unitSaveFile = new File(Config.UNITSAVE_PATH);
            bo = new BufferedOutputStream(new FileOutputStream(unitSaveFile));
            //player's info
            bo.write(player.getHp());
            bo.write(player.getMaxHp());
            bo.write(player.getAttackDamage());
            bo.write(player.getDef());
            if(player.isHasWeapon())
                bo.write(1);
            else
                bo.write(0);
            bo.write(player.getWeaponDamage());
            if(player.isHasArmor())
                bo.write(1);
            else
                bo.write(0);
            bo.write(player.getArmorDefence());
            //monster's info
            GameObject[][] temp = worldMap.getWorldMap();
            for(int i=0;i<worldMap.getMapRows();i++)
            {
                for(int j=0;j<worldMap.getMapCols();j++)
                {
                    if(temp[i][j] instanceof Monster)
                    {
                        bo.write(temp[i][j].getRow());
                        bo.write(temp[i][j].getCol());
                        bo.write(((Monster)temp[i][j]).getHp());
                        bo.write(((Monster)temp[i][j]).getMaxHp());
                        bo.write(((Monster)temp[i][j]).getAttackDamage());
                        bo.write(((Monster)temp[i][j]).getDef());
                    }

                }
            }

            System.out.println(">>Save complete.");
        }
        catch (IOException e)
        {
            System.out.println("$$Save error.");
        }
        finally
        {
            try
            {
                bw.close();
                bo.close();
            }
            catch (IOException e)
            {
            	System.out.println();
            }
        }
    }

    public void load()
    {
        System.out.println(">>Loading objects...");
        try
        {
            //Object position
            mapSaveFile = new File(Config.MAPSAVE_PATH);
            br = new BufferedReader(new FileReader(mapSaveFile));
            ArrayList<char[]> mapTemp = new ArrayList<>();
            while(br.ready())
            {
                mapTemp.add(br.readLine().toCharArray());
            }
            mapTemp.toArray(map);
            worldMap.initialize(map);
            linkWorldMap(worldMap);
            //Unit status
            unitSaveFile = new File(Config.UNITSAVE_PATH);
            bi = new BufferedInputStream(new FileInputStream(unitSaveFile));
            player.setHp(bi.read());
            player.setMaxHp(bi.read());
            player.setAttackDamage(bi.read());
            player.setDef(bi.read());
            if(bi.read()==1) //has weapon
            {
                player.setWeaponDamage(bi.read());
                player.setHasWeapon(true);
                player.setWeaponName(Config.WEAPON_NAME);
            }
            else
            {
                bi.read();
            }
            if(bi.read()==1) //has armor
            {
                player.setArmorDefence(bi.read());
                player.setHasArmor(true);
                player.setArmorName(Config.ARMOR_NAME);
            }
            else
            {
                bi.read();
            }

            GameObject[][] temp = worldMap.getWorldMap();
            while(bi.available()!=0)
            {
                Monster monsterTemp = ((Monster)temp[bi.read()][bi.read()]);
                monsterTemp.setHp(bi.read());
                monsterTemp.setMaxHp(bi.read());
                monsterTemp.setAttackDamage(bi.read());
                monsterTemp.setDef(bi.read());
            }
            System.out.println(">>Load complete.");
        } catch (IOException e)
        {
        	System.out.println("$$Load error.");
        }
        finally
        {
            try
            {
                br.close();
                bi.close();
            }
            catch (IOException e)
            {
            	System.out.println();
            }
        }

    }

    public void linkWorldMap(WorldMap w)
    {
        this.worldMap = w;
        this.player = w.getPlayer();
    }

    public char[][] getCharMap()
    {
        return map;
    }

    private void worldMapToChar()
    {
        int row = worldMap.getMapRows();
        int col = worldMap.getMapCols();
        GameObject[][] objMap = worldMap.getWorldMap();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                map[i][j] = objMap[i][j].getIcon();
            }
        }
    }

}
