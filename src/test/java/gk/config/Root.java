package gk.config;

import java.util.List;

public class Root {
    private List<Provider> provider;

    private List<Resource> resource;

    public void setProvider(List<Provider> provider){
        this.provider = provider;
    }
    public List<Provider> getProvider(){
        return this.provider;
    }
    public void setResource(List<Resource> resource){
        this.resource = resource;
    }
    public List<Resource> getResource(){
        return this.resource;
    }
}
