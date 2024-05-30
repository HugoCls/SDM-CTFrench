import mysql.connector
from mysql.connector import Error

def connect_to_database():
    try:
        conn = mysql.connector.connect(
            host='79.137.38.217',
            database='ctf',
            user='overcop_user',
            password='Uqo08o_01'
        )

        if conn.is_connected():
            print("Connected to the database")
            return conn
    except Error as e:
        print(f"Error: {e}")
        return None

def clear_database(conn):
    cursor = conn.cursor()
    try:
        # Récupérer toutes les tables de la base de données
        cursor.execute("SHOW TABLES;")
        tables = cursor.fetchall()
        
        # Désactiver les contraintes de clé étrangère
        cursor.execute("SET FOREIGN_KEY_CHECKS = 0;")
        
        # Supprimer toutes les tables
        for table in tables:
            cursor.execute(f"DROP TABLE IF EXISTS `{table[0]}`;")
        
        # Réactiver les contraintes de clé étrangère
        cursor.execute("SET FOREIGN_KEY_CHECKS = 1;")
        
        print("All tables dropped successfully")
    except Error as e:
        print(f"Error: {e}")
    finally:
        cursor.close()

def recreate_database(conn):
    cursor = conn.cursor()
    try:
        # Définir les commandes SQL pour recréer la base de données
        sql_commands = [
            "SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';",
            "SET time_zone = '+00:00';",
            "CREATE TABLE IF NOT EXISTS `users` ("
            "  `id` int(11) NOT NULL,"
            "  `firstName` varchar(100) DEFAULT NULL,"
            "  `lastName` varchar(100) DEFAULT NULL,"
            "  `email` varchar(100) DEFAULT NULL,"
            "  `username` varchar(100) DEFAULT NULL,"
            "  `password` varchar(100) DEFAULT NULL,"
            "  `isModerator` tinyint(1) NOT NULL DEFAULT '0'"
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;",
            "INSERT INTO `users` (`id`, `firstName`, `lastName`, `email`, `username`, `password`, `isModerator`) VALUES"
            "(1, 'Paul', 'FRADET', 'paul.fradet@gmail.com', 'Admin', 'ThisIsAReallyStr0ngP@ssw0rd__!', 1),"
            "(2, 'Baptiste', 'SERIN', 'serinbaptiste@gmail.com', 'SerinooBaptman', '123456', 0),"
            "(3, 'Romain', 'NTAMAK', 'rom1ntam@yahoo.fr', 'RomRomak', 'romntam123', 0),"
            "(4, 'Gabin', 'VILLIERE', 'gab_vil@hotmail.fr', 'Gaboudu14', 'vilgab83!', 0),"
            "(5, 'sebastien', 'CHABAL', 'chabaaal_seb@orange.fr', 'Chaboubou', 'rugbylover', 0),"
            "(6, 'Dany', 'PRISOT', 'dany.prisot@gmail.com', 'danPris', 'soleil123', 0),"
            "(7, 'Isa', 'FACUNDO', 'isafacund@hotmail.com', 'IsaFacky', 'facunisa789', 0),"
            "(8, 'Antoine', 'DUPONT', 'antoine.dupont@gmail.com', 'AntoDupdup', 'best9inworld', 0),"
            "(9, 'Fracois', 'Xavier', 'flag@gmail.com', 'THEFRENCHKEBAB', 'CTFrench{SQL_Sh0uld_b3_Pr0t3ct3d}', 0),"
            "(10, 'Pouet', 'Klouch', 'pouet.klouch@outlook.fr', 'PoutPout12', 'Kloucydu54', 0);",
            "ALTER TABLE `users` ADD PRIMARY KEY (`id`);",
            "ALTER TABLE `users` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;"
        ]

        # Exécuter chaque commande SQL
        for command in sql_commands:
            cursor.execute(command)

        # Valider les changements
        conn.commit()
        print("Database recreated successfully")
    
    except Error as e:
        print(f"Error: {e}")
        conn.rollback()

    finally:
        cursor.close()

if __name__ == '__main__':
    conn = connect_to_database()
    if conn:
        clear_database(conn)
        recreate_database(conn)
        conn.close()
