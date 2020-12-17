import java.io.File;
import java.util.ArrayList;

public class ThreadSplitter {
    public static ArrayList<ArrayList<File>> getArraysForThread(int processorAmount, File[] images) {
        ArrayList<ArrayList<File>> arrayOfArrayOfImages = new ArrayList<>();
        for (int i = 0; i < processorAmount; i++) arrayOfArrayOfImages.add(i, new ArrayList<>());
        for (int i = 0; i < images.length; i++) {
            ArrayList<File> buff = arrayOfArrayOfImages.get(i % processorAmount);
            arrayOfArrayOfImages.remove(buff);
            buff.add(images[i]);
            arrayOfArrayOfImages.add(i % processorAmount, buff);
        }
        return arrayOfArrayOfImages;
    }
}
