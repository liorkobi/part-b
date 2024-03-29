package IO;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
    private InputStream in;

    public MyDecompressorInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    /**
     * override the read method in order to decompress as wanted
     * @param b   the buffer into which the data is read.
     * @return
     * @throws IOException
     */
    @Override
    public int read(byte b[]) throws IOException { //convert decimal number to binary
        int len = b.length;
        byte[] compress_IN = in.readAllBytes();
        int idx = compress_IN[compress_IN.length - 1];

        System.arraycopy(compress_IN, 0, b, 0, (compress_IN[compress_IN.length - 1]));


        for (int j = compress_IN[compress_IN.length - 1]; j < compress_IN.length; j++) {
            int number = compress_IN[j];
            if (number < 0){
                number = 256 + number ;
            }
            int curr = 0;
            while((number > 0 || curr < 8) &&(idx< len)){

                byte value = (byte) (number % 2);
                b[idx++] = value;
                number = number / 2;
                curr++;

            }
        }
        return len;
    }
}