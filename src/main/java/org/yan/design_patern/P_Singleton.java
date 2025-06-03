package org.yan.design_patern;

/**
 * Une classe donnée ne doit avoir qu'une seule instance. Nous n'utiliserons que cette instance en cas de besoin.
 *
 * Exemple concret
 * Supposons que vous soyez membre d'une équipe de cricket. Lors d'un tournoi, votre équipe affronte une autre équipe. Conformément aux règles du jeu, le capitaine de chaque équipe doit tirer au sort pour déterminer quelle équipe jouera en premier. Ainsi, si votre équipe n'a pas de capitaine, vous devez d'abord élire quelqu'un comme capitaine. De plus, votre équipe ne peut pas avoir plus d'un capitaine.

 * Exemple informatique
 * Dans un système logiciel, il est parfois possible de n'utiliser qu'un seul système de fichiers. Il est généralement utilisé pour la gestion centralisée des ressources.

 * Illustration
 * Dans cet exemple, nous avons d'abord rendu le constructeur privé, ce qui empêche toute instanciation normale.
 * Lorsque nous tentons de créer une instance de la classe, nous vérifions si nous en avons déjà une copie disponible. Si nous n'en avons pas, nous la créons ; sinon, nous réutiliserons simplement la copie existante.
 */
public class P_Singleton {

    static class MakeACaptain
    {
        private static MakeACaptain _captain;
        //We make the constructor private to prevent the use of "new"
        private MakeACaptain() { }
        public static MakeACaptain getCaptain()
        {

            // Lazy initialization
            if (_captain == null)
            { _captain = new MakeACaptain();
                System.out.println("New Captain selected for our team");
            } else
            {
                System.out.print("You already have a Captain for your team.");
                System.out.println("Send him for the toss.");
            }
            return _captain;

        }
    }
}
class SingletonPatternEx
{
    public static void main(String[] args)
    {
        System.out.println("***Singleton Pattern Demo***\n");
        System.out.println("Trying to make a captain for our team");
        P_Singleton.MakeACaptain c1 = P_Singleton.MakeACaptain.getCaptain();
        System.out.println("Trying to make another captain for our team");
        P_Singleton.MakeACaptain c2 = P_Singleton.MakeACaptain.getCaptain();
        if (c1 == c2)
        {
            System.out.println("c1 and c2 are same instance");
        }
    }

}
