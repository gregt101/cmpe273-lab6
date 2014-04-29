package edu.sjsu.cmpe.cache.client;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
        CacheServiceInterface cache_n1 = new DistributedCacheService(
                "http://localhost:3000");
        CacheServiceInterface cache_n2 = new DistributedCacheService(
                "http://localhost:3001");
        CacheServiceInterface cache_n3 = new DistributedCacheService(
                "http://localhost:3003");

        cache.put(1, "foo");
        System.out.println("put(1 => foo)");

        String value = cache.get(1);
        System.out.println("get(1) => " + value);

        System.out.println("Existing Cache Client...");
    }

}
