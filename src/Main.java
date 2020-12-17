import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String srcFolder = "src/images";
        String dstFolder = "src/dst";
        File dir = new File("src/images");
        File[] images = dir.listFiles();
        long start = System.currentTimeMillis();
        try {
            if (!Files.exists(Paths.get(dstFolder))) {
                Files.createDirectories(Paths.get(dstFolder));
            }
            ArrayList<TreadImage> treadImages = new ArrayList<>();
            ArrayList<ArrayList<File>> splitedImages = ThreadSplitter.getArraysForThread(Runtime.getRuntime().availableProcessors(), images);
            for (int i = 0; i < splitedImages.size(); i++) {
                treadImages.add(new TreadImage(dstFolder, splitedImages.get(i), start));
            }
            for (TreadImage e : treadImages) e.run();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}