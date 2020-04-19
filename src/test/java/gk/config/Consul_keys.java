package gk.config;

import java.util.List;

public class Consul_keys {
    private List<App> app;

    public void setApp(List<App> app){
        this.app = app;
    }
    public List<App> getApp(){
        return this.app;
    }
}
