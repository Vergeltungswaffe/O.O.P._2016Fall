package gameobjects;

import gameinterfaces.Movable;

public class Rock extends Obstacle implements Movable
{
    public Rock(int row, int col)
    {
        super(row, col);
        setIcon('R');
    }

    private void printCannotMove()
    {
        System.out.println("Cannot move.");
    }

    private void printMoved()
    {
        System.out.println("Rock moved.");
    }

    @Override
    public void showMenu()
    {
        System.out.println("(P)ush / (N)othing ? : ");
    }

    @Override
    public void inputCommand(Player player, GameObject[][] ent, int row, int col, char command)
    {
        if(command=='P')
        {
            //move left
            if(player.getRow()==row&&player.getCol()==col+1)
            {
                if(col==0)
                {
                    printCannotMove();
                    return;
                }
                if(ent[row][col-1] instanceof Space)
                {
                    this.moveTo(ent, row, col-1);
                    printMoved();
                }
                else
                    printCannotMove();
            }
            //move right
            else if(player.getRow()==row&&player.getCol()==col-1)
            {
                if(col==ent[0].length)
                {
                    printCannotMove();
                    return;
                }
                if(ent[row][col+1] instanceof Space)
                {
                    this.moveTo(ent, row, col+1);
                    printMoved();
                }
                else
                    printCannotMove();
            }
            //move up
            else if(player.getRow()==row+1&&player.getCol()==col)
            {
                if(row==0)
                {
                    printCannotMove();
                    return;
                }
                if(ent[row-1][col] instanceof Space)
                {
                    this.moveTo(ent, row-1, col);
                    printMoved();
                }
                else
                    printCannotMove();
            }
            //move down
            else if(player.getRow()==row-1&&player.getCol()==col)
            {
                if(row==ent.length)
                {
                    printCannotMove();
                    return;
                }
                if(ent[row+1][col] instanceof Space)
                {
                    this.moveTo(ent, row+1, col);
                    printMoved();
                }
                else
                    printCannotMove();
            }
        }
        else if(command=='N')
        {
            System.out.println("You did nothing.");
        }
        else
        {
            System.out.println("Invalid input.");
        }
    }

    @Override
    public void moveTo(GameObject[][] ent, int row, int col)
    {
        int beforeRow = getRow();
        int beforeCol = getCol();
        ent[row][col] = this;
        setRow(row);
        setCol(col);
        ent[beforeRow][beforeCol] = new Space(beforeRow, beforeCol);
    }
}