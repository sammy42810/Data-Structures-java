/*
Sam Bryan
HW1
I pledge my honor that I have abided by the Stevens Honor System
*/

public static class BinaryNumber {
    private int[] data;
    private final int length;

    public BinaryNumber(int length){
        this.length = length;
        this.data = new int[length];
    }
    public BinaryNumber(String str){
        this.length = str.length();
        this.data = new int[length];

        for(int i = 0; i<length; i++){
            char n = str.charAt(i);
            data[i] = n;
        }
    }
    /**
     * Determining the length of a binary number
     * @return the length of the BinaryNumber
     * */
    public int getLength(){
        return data.length;
    }

    /**
     * Returns a specific digit in the Binary Number
     *
     * @return the digit at the index given
     */
    public int getDigit(int index){
        if((index < 0) || index > length - 1){
            throw new IllegalArgumentException("The index is out of bounds!");
        }
        return data[index];
    }

    /**
     * @return the integer array representing the Binary number
     * */
    public int[] getInnerArray(){
        return data;
    }

    /**
     * @return computes the bitwise or of the two numbers.
     * */
    public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2){
        int[] temp = new int[bn1.length];
        if(bn1.length != bn2.length) {
            throw new IllegalArgumentException("Has to be same length");
        }
        for (int i = 0; i < bn1.length; i++) {
            if (bn1.data[i] + bn2.data[i] == 0) {
                temp[i] = 0;
            } else {
                temp[i] = 1;
            }
        }
        return temp;
    }

    /**
     * @return computes the bitwise and of the two numbers.
     * */
    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2){
        int[] temp = new int[bn1.length];
        if(bn1.length != bn2.length) {
            throw new IllegalArgumentException("Has to be same length");
        }
        for (int i = 0; i < bn1.length; i++) {
            if (bn1.data[i] + bn2.data[i] == 2) {
                temp[i] = 1;
            } else {
                temp[i] = 0;
            }
        }
        return temp;
    }
    }

    /**
     * shifts the binary number x amount of bits  */
    public void bitShift(int direction, int amount){
        if ((amount > data.length) && (direction == 1)) {
            throw new IllegalArgumentException("Cannot be larger than the bit length");
        }
        if (direction == 1) {
            int[] temp = new int[data.length - amount];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
            length = data.length;
        }
        if (direction == -1){
            int[] temp = new int[data.length];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            for(int i = data.length; i < temp.length+amount; i++) {
                temp[i] = 0;
            }
            data = temp;
            length = data.length;
        }
    }

    /**
     * adds two binary numbers
     **/
    public void add(BinaryNumber aBinaryNumber) {
        int a;
        int b = 0;
        int[] temp;
        if (data.length > aBinaryNumber.data.length) {
            temp = new int[data.length];
        }
        else {
            temp = new int[aBinaryNumber.data.length];
        }
        if (data.length != aBinaryNumber.data.length){
            int[] two;
            if(data.length < aBinaryNumber.data.length) {
                two = new int[aBinaryNumber.data.length];
                a = aBinaryNumber.data.length - data.length;
                for (int i = 0; i < a; i++) {
                    two[i] = 0;
                }
                for (int i = a; i < aBinaryNumber.data.length; i++) {
                    two[i] = data[i - a];
                }
                data = two;
            }
            else if (data.length > aBinaryNumber.data.length) {
                two = new int[data.length];
                a = data.length - aBinaryNumber.data.length;
                for (int i = 0; i < a; i++) {
                    two[i] = 0;
                }
                for (int i = a; i < data.length; i++) {
                    two[i] = aBinaryNumber.data[i - a];
                }
                aBinaryNumber.data = two;
            }
        }
            for(int i = temp.length - 1; i >= 0; i--) {
                if (data[i] + aBinaryNumber.data[i] + b == 0) {
                    temp[i] = 0;
                    b = 0;
                } else if (data[i] + aBinaryNumber.data[i] + b == 1) {
                    temp[i] = 1;
                    b = 0;
                } else if (data[i] + aBinaryNumber.data[i] + b == 2) {
                    temp[i] = 0;
                    b = 1;
                } else if (data[i] + aBinaryNumber.data[i] + b == 3) {
                    temp[i] = 1;
                    b = 1;
                }
            }
            if(b==1) {
                int[] tri = new int[aBinaryNumber.data.length + 1];
                tri[0] = 1;
                for (int i = 1; i < tri.length; i++) {
                    tri[i] = tri[i - 1];
                }
                temp = tri;
            }
            data = temp;
            length = temp.length;
    }

    /**
     * @return turns the binary number into a string representation
    **/
    public String toString(){
        StringBuilder binaryString = new StringBuilder();
        for(int digit : data) {
            binaryString.append(digit);
        }
        return binaryString.toString();
    }

    /**
     * @return the decimal representation of the binary number
     * */
    public int toDecimal(){
        int decimal = 0;
        for (int i = data.length -1; i >= 0; i--) {
            decimal += (int) (data[i] * Math.pow(2, data.length - 1 - i));
        }
        return decimal;
        }
    }
}
