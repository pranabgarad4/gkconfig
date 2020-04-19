package gk.config;

public class Consul {
    private String address;

    private String datacenter;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    public String getDatacenter() {
        return this.datacenter;
    }
}
