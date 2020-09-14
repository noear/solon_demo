package webapp;

import org.junit.Test;
import webapp.utils.IPFSUtil;

import java.io.File;
import java.io.IOException;

public class IPFSTest {
    @Test
    public void testAdd() {
        try {
            File file = new File("/Users/xieyuejia/Downloads/nmqh.JPG");

            String hash = IPFSUtil.add(file);
            System.out.println(hash);
            // QmfGp2pRCs3VidFKEVh6NFdrJ3usfrRDr2KXW9k4t3EfUK
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCat() {
        try {
            String data = IPFSUtil.cat("QmfGp2pRCs3VidFKEVh6NFdrJ3usfrRDr2KXW9k4t3EfUK");
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
