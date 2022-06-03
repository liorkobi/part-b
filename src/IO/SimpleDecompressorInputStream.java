package IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream in;

    public SimpleDecompressorInputStream(InputStream in) {
        this.in = in;
    }


    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] Final) throws IOException {
        byte[] b = in.readAllBytes();
        System.arraycopy(b, 0, Final, 0, (b[b.length - 1])-1);
        boolean bool=true;
        int pointer=b[b.length - 1];
        for(int j=b[b.length - 1];j<b.length-1;j++){
            if (bool){
            for(int k=0;k<b[j];k++){
                Final[pointer]=0;pointer++;}
                bool=false;}
            else {
            for(int k=0;k<b[j];k++){
                Final[pointer]=1;pointer++;
            }bool=true;}

        }


            return 0;
    }
}