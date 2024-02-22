package Logica;

import java.util.Random;

public class LanzamientoDados {
    public static int lanzarDados() {
        return new Random().nextInt(6) + 1 + new Random().nextInt(6) + 1;
    }
}
