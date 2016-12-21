package gameinterfaces;

import gameobjects.GameObject;

public interface Movable
{
    void moveTo(GameObject[][] ent, int row, int col);
}