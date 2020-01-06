package ua.nure.bogun.brainfuck;

/**Memory Implementation
 * This class contains memory-array to which all commands of brainfuck language are applied
 * Memory always have static length as byte size
 * We declare pointer to get at which position we are during execution.
 * As we have only one memory to make all operations, it is good idea to make it Singleton.
 */
public class Memory {
    private static Memory instance;
    private static final int LENGTH = 65535;
    private int pointer;
    public byte[] arr;

    /**
     * Memory constructor initiates memory and pointer
     */
    Memory() {
        arr = new byte[LENGTH];
        pointer = 0;
    }
    /**
     * Method to get instance of created memory
     */
    public static synchronized Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    /**
     * Method to remove instance of created memory
     */
    public static synchronized void removeInstance() {
        instance = null;
    }

    /**
     * @return getter for current position in memory
     */
    public int getPointer() {
        return pointer;
    }

    /**
     * @param pointer set new pointer
     * if pointer is outside memory, it will go to the beginning
     * through that we get cyclic iterator
     * @return new pointer
     */
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

