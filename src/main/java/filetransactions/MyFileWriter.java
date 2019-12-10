package filetransactions;

import java.io.*;
import java.util.List;

public class MyFileWriter<T> {

    public void dosyayaYaz(String filePath, List<T> typeList) {
        try{
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(typeList);

            System.out.println("The Object  was succesfully written to a file");

            objectOut.flush();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
