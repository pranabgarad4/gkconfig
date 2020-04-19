package gk.config;

import java.util.List;

public class App {
    private String datacenter;

    private List<Key> key;

    private String token;

    public void setDatacenter(String datacenter){
        this.datacenter = datacenter;
    }
    public String getDatacenter(){
        return this.datacenter;
    }
    public void setKey(List<Key> key){
        this.key = key;
    }
    public List<Key> getKey(){
        return this.key;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }
}
