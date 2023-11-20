using System;
namespace overerving
{
	public class Player
	{
        public int healthPoints = 100;
        public Attack[] attacks = { new overerving.Attack("nothing", 0) };

        public Player()
        {
        }
    }
}

