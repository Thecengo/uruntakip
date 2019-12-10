package filetransactions;

import java.io.*;
import java.util.List;

public class FileInput<T> implements Inputable<T> {

    @Override
    public List<T> dosyadanOku(String filePath) {
        List<T> tList = null;
        try {
            FileInputStream fileOut = new FileInputStream(filePath);
            ObjectInputStream objectOut = new ObjectInputStream(fileOut);

            tList = (List<T>) objectOut.readObject();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return tList;
    }

}

