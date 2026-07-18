//currently unused, taken from other project

public class VMStack {

    private final long[] buf;
    private int sp;

    public VMStack(int size) {

        buf = new long[size];
        sp = -1;
    }

    public void push(long number) {

        if (sp + 1 >= buf.length) {

            System.out.println("Stack overflow");
            System.exit(1);
        }

        buf[++sp] = number;
    }

    public long pop() {

        if (sp < 0) {

            System.out.println("Stack underflow");
            System.exit(1);
        }

        return buf[sp--];
    }

    public long top() {

        if (sp < 0) {

            System.out.println("Stack empty");
            System.exit(1);
        }

        return buf[sp];
    }

    public long peek(int offset) {

        if (sp - offset < 0) {

            System.out.println("Invalid stack peek");
            System.exit(1);
        }

        return buf[sp - offset];
    }
    
    public int getSP() {
        return sp;
    }
}

