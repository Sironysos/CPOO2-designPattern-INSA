package exercises.exercise6;

public class LazyObj {
    /* private static LazyObj instance = null;

    private LazyObj() {
    }

    public static LazyObj getInstance() {
        if (instance == null) {
            instance = new LazyObj();
        }
        return instance;
    } */
   
   
    //Attention, ce qui suit n'est pas un proxy, mais une instanciation paresseuse
   
    private Object bar; //on peut embêté parce que bar ne peut pas être final (jamais instancié sauf dans getBar)
    // final c'est presque l'inverse de lazy
    public Object getBar() {
        if (bar == null) {
            bar = new Object();
        }
        return bar;
    }
}
