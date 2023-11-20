using System;
namespace overerving
{
	public class Enemy
	{
		public int healthPoints = 100;
		public Attack[] attacks = { new overerving.Attack("bite", 20) };

		public Enemy()
		{
		}

		public Attack Attack()
		{
			return attacks[0];
		}
	}
}

