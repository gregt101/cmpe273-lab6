package edu.sjsu.cmpe.cache.client;
import com.google.common.hash.Hashing;
import java.util.List;
import java.util.ArrayList;

public class Client {
    
    //private List<CacheServiceInterface> cache;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
        CacheServiceInterface cache_n1 = new DistributedCacheService(
                "http://localhost:3000");
        CacheServiceInterface cache_n2 = new DistributedCacheService(
                "http://localhost:3001");
        CacheServiceInterface cache_n3 = new DistributedCacheService(
                "http://localhost:3002");
        int key = 0;
        char value = 'a';
        int node;
        
        List<CacheServiceInterface> cache = new ArrayList<CacheServiceInterface>();
        cache.add(cache_n1);
        cache.add(cache_n2);
        cache.add(cache_n3);
        
        while ((key<10)&&(cache.size()>0)){
            key++;
            node = Hashing.consistentHash(Hashing.md5().hashString(Integer.toString(key)), cache.size());
            //cache.put(1, "foo");
            cache.get(node).put(key, Character.toString(value));
            
            //System.out.println("put(1 => foo)");
            System.out.println("put("+key +"=>"+ value+")");
            
            //String value = cache.get(1);
            //System.out.println("get(1) => " + value);
            System.out.println("get("+key +") =>"+ cache.get(node).get(key));
        }


        System.out.println("Existing Cache Client...");
    }

}
