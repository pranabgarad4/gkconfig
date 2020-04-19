package gk.config;


import java.util.List;

public class Resource {
    private List<Consul_keys> consul_keys;

    public void setConsul_keys(List<Consul_keys> consul_keys) {
        this.consul_keys = consul_keys;
    }

    public List<Consul_keys> getConsul_keys() {
        return this.consul_keys;
    }
}
