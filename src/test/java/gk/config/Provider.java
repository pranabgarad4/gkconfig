package gk.config;

import java.util.List;

public class Provider {
    private List<Consul> consul;

    public void setConsul(List<Consul> consul){
        this.consul = consul;
    }
    public List<Consul> getConsul(){
        return this.consul;
    }
}
