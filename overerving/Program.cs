class Program
{
    public static void Main(string[] args)
    {
        bool quit = false;
        overerving.Enemy enemy = new overerving.Enemy();
        overerving.Player player = new overerving.Player();

        while (!quit)
        {
            // Enemy's turn
            Console.WriteLine("The enemy's turn!");
            overerving.Attack enemyAttack = enemy.Attack();
            Console.WriteLine("The enemy attacks with " + enemyAttack.name);
            player.healthPoints -= enemyAttack.damage;
            Console.WriteLine("Your health: " + player.healthPoints);

            // Did the enemy win?
            if (player.healthPoints <= 0)
            {
                Console.WriteLine("Alas, you have been defeated.");
                quit = true;
                break;
            }

            // Player's turn
            Console.WriteLine("Your turn! What will you do?");
            for (int i = 0; i < player.attacks.Length; i++)
            {
                Console.WriteLine("[" + i + "] " + player.attacks[i].name);
            }
            int selectedAttack = Convert.ToInt32(Console.ReadLine());
            overerving.Attack playerAttack = player.attacks[selectedAttack];
            Console.WriteLine("You attack the enemy with " + playerAttack.name);
            enemy.healthPoints -= playerAttack.damage;
            Console.WriteLine("Enemy's health: " + enemy.healthPoints);

            // Did the player win?
            if (enemy.healthPoints <= 0)
            {
                Console.WriteLine("Congrats! You have defeated the enemy.");
                quit = true;
                break;
            }
        }
    }
}