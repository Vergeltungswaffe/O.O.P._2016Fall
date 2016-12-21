package finalPJ;

public class Roguelike
{
    public static void main(String[] args)
    {
    	try
    	{
        Config.printOpenCredit();
        WorldMap gameMap = new WorldMap();
        FileManager file = new FileManager();
        char[][] map = file.buildMap();
        gameMap.initialize(map);

        gameMap.linkFileManager(file);
        file.linkWorldMap(gameMap);

        gameMap.run();
        Config.printEndCredit();
    	}
    	catch(Exception e)
    	{
    		System.out.println("\n$$Error detected.");
    	}
        
    }
}