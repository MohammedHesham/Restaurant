package aast.restaurant.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ImageUtil {


    public static void downloadImage(String search, String path) {

        // This will get input data from the server
        InputStream inputStream;

        // This will read the data from the server;
        OutputStream outputStream;

        try {
            // This will open a socket from client to server
            URL url = new URL(search);

            // This user agent is for if the server wants real humans to visit
            String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

            // This socket type will allow to set user_agent
            URLConnection con = url.openConnection();

            // Setting the user agent
            con.setRequestProperty("User-Agent", USER_AGENT);

            // Requesting input data from server
            inputStream = con.getInputStream();

            // Open local file writer
            outputStream = new FileOutputStream(path);

            // Limiting byte written to file per loop
            byte[] buffer = new byte[2048];

            // Increments file size
            int length;

            // Looping until server finishes
            while ((length = inputStream.read(buffer)) != -1) {
                // Writing data
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ImageView getIcon() {
        //creating the image object
        try {
            InputStream stream = new FileInputStream("icon.png");
            Image image = new Image(stream);
            //Creating the image view
            javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView();
            //Setting image to the image view
            imageView.setImage(image);
            return imageView;
        } catch (Exception e) {
            return null;
        }
    }

    public static ImageView getProfileIcon() {
        //creating the image object
        try {
            InputStream stream = new FileInputStream("profile.png");
            Image image = new Image(stream);
            //Creating the image view
            javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView();
            //Setting image to the image view
            imageView.setImage(image);
            return imageView;
        } catch (Exception e) {
            return null;
        }
    }

    public static ImageView toImageView(String path) {
        //creating the image object
        try {
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            //Creating the image view
            javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView();
            //Setting image to the image view
            imageView.setImage(image);
            return imageView;
        } catch (Exception e) {
            return null;
        }
    }
}
