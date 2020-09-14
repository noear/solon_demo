package webapp.utils;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.File;
import java.io.IOException;

public class IPFSUtil {
    private static IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");

    public static String add(File file0) throws IOException {
        NamedStreamable.FileWrapper fileWrap = new NamedStreamable.FileWrapper(file0);
        MerkleNode addResult = ipfs.add(fileWrap).get(0);
        return addResult.hash.toString();
    }

    public static String cat(String hash) throws IOException {
        byte[] data = ipfs.cat(Multihash.fromBase58(hash));
        return new String(data);
    }
}
