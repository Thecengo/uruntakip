package filetransactions;

import java.util.List;

public interface Inputable<T> {

    public List<T> dosyadanOku(String filePath);

}
