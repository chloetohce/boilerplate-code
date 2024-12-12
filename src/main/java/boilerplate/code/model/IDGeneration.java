package boilerplate.code.model;

import java.util.Random;

public class IDGeneration {
    private static final Random RANDOM = new Random();

    private String id;

    public IDGeneration() {
        this.id = String.format("%08x", RANDOM.nextLong(0x50000000));
    }

    @Override
    public String toString() {
        return "IDGeneration [id=" + id + "]";
    }
}
