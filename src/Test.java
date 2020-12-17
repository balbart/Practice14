import java.io.File;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        int processorAmount = Runtime.getRuntime().availableProcessors();
//        System.out.println(processorAmount);
        File dir = new File("src/images");
        File[] images = dir.listFiles();
        ArrayList<ArrayList<File>> arrayOfArrayOfImages = new ArrayList<ArrayList<File>>();
        for (int i = 0; i < processorAmount; i++) {
            arrayOfArrayOfImages.add(i, new ArrayList<>());
        }
        for(int i = 0; i < images.length; i++){
            ArrayList<File> buff = arrayOfArrayOfImages.get(i % processorAmount);
            arrayOfArrayOfImages.remove(buff);
            buff.add(images[i]);
            arrayOfArrayOfImages.add(i % processorAmount, buff);
        }
        System.out.println(arrayOfArrayOfImages.size());
        for(ArrayList<File> e: arrayOfArrayOfImages) System.out.println(e);
    }
}
