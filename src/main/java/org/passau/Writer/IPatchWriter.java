package org.passau.Writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IPatchWriter {

    private PrintWriter out;

    public IPatchWriter(String logName) {
        try {
            FileWriter fwOb = new FileWriter(logName+".txt", false);
            out = new PrintWriter(fwOb, false);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(Object data, boolean isFinished){

        if (!isFinished){
            out.println(data);
        }else{
            out.println(data);
            //out.close();
        }
    }

    public void closeFiles()
    {
        out.close();
    }
}
