package ua.nure.bogun.brainfuck;

public class Array {
    private static Array instance;
    private static final int LENGTH = 65535;
    private int pointer;
    public byte[] arr;

    Array() {
        arr = new byte[LENGTH];
        pointer = 0;
    }
    public static synchronized Array getInstance() {
        if (instance == null) {
            instance = new Array();
        }
        return instance;
    }

    public int getPointer() {
        return pointer;
    }

    public int setPointer(int pointer) {
        if (pointer >= arr.length) {
            this.pointer = pointer - arr.length;
        } else if (pointer < 0) {
            this.pointer = arr.length + pointer;
        } else {
            this.pointer = pointer;
        }
        return this.pointer;
    }


}

