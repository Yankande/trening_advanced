package org.yan.design_patern;

/**
 * Dans ce modèle, de nombreux observateurs (objets) observent un sujet particulier.
 * Les observateurs sont fondamentalement intéressés et souhaitent être informés de toute modification apportée à ce sujet.
 * Ils s'enregistrent donc auprès de ce sujet. Lorsqu'ils s'en désintéressent, ils se désinscrivent simplement.
 * Ce modèle est parfois appelé modèle Éditeur-Abonné.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Exemple concret
 * Prenons l'exemple d'une célébrité qui compte de nombreux fans.
 * Chacun d'eux souhaite suivre les dernières actualités de sa célébrité préférée.
 * Il peut donc la suivre tant que son intérêt persiste. Lorsqu'il perd son intérêt,
 * il cesse tout simplement de la suivre. On peut alors considérer le fan comme un observateur et la célébrité comme un sujet.
 */
public class P_Observer {

    public void update()
    {
        System.out.println("flag value changed in Subject");
    }

    public interface ISubject
    {
        void register(P_Observer o);
        void unregister( P_Observer o);
        void notifyObservers();
    }

    static class Subject implements ISubject {
        List<P_Observer> observerList = new ArrayList<P_Observer>();
        private int _flag;

        public int getFlag() {
            return _flag;
        }

        public void setFlag(int _flag)
        {
            this._flag=_flag;
            //flag value changed .So notify observer(s)
            notifyObservers();
        }
        @Override
        public void register(P_Observer o)
        {
            observerList.add(o);
        }
        @Override
        public void unregister(P_Observer o)
        {
            observerList.remove(o);
        }
        @Override
        public void notifyObservers()
        {
            for (P_Observer pObserver : observerList) {
                pObserver.update();
            }
        }



    }

    static class ObserverPatternEx {
        public static void main(String[] args) {
            System.out.println("***Observer Pattern Demo***\n");
            P_Observer o1 = new P_Observer();
            Subject sub1 = new Subject();
            sub1.register(o1);
            System.out.println("Setting Flag = 5 ");
            sub1.setFlag(5);
            System.out.println("Setting Flag = 25 ");
            sub1.setFlag(25);
            sub1.unregister(o1);
            //No notification this time to o1 .Since it is unregistered.
            System.out.println("Setting Flag = 50 ");
            sub1.setFlag(50);
        }
    }
}
