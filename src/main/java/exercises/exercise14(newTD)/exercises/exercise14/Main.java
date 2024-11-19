package exercises.exercise14(newTD);

interface Canard {
    String coinCoin();
    String danser();
}
class Loup {
    String coinCoin() {
        return "COIN COIN OUUUH";
    }
    String danser() {
        return "\\_ ( ) _/";
    }
    String manger(Canard c) {
        return "\\_ (@@) _/";
    }
}

class CanardAdapter implements Canard {
    private Loup loup;
    public CanardAdapter(Loup loup) {
        this.loup = loup;
    }

    // setter loup
    public void setLoup(Loup loup) {
        this.loup = loup;
    }

    @Override
    public String coinCoin() {
        return loup.coinCoin();
    }
    @Override
    public String danser() {
        return loup.danser();
    }
}

public class Main {
    public static void main(final String[] args) {
        final Loup loup = new Loup();
        // Canard canard = loup; //does not compile: nominal typing
        Canard canard = new CanardAdapter(loup);
        canard.coinCoin();
        canard.danser();

        loup.manger(new CanardAdapter(new Loup()));

        System.out.println(canard.coinCoin());
        System.out.println(canard.danser());
    }
    
}
