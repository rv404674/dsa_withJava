package creational.builder.sudocode;

public class UrlNew {

    // NOTE: To use builder pattern
    // TODO: implement this later - https://www.baeldung.com/creational-design-patterns
    // have an inner nested static class
    // same fields as URL
    // inner class Builder should also have constructoe for all field
    // with only exception that it will return Builder type

    // NOTE: sudocode way is correct, PP had also used this somewhere.
    public final String protocol;
    public final String hostName;
    public final String port;
    public final String pathName;
    public final String queryParam;

    private UrlNew(Builder builder){
        this.protocol = builder.protocol;
        this.hostName = builder.hostName;
        this.port = builder.port;
        this.pathName = builder.pathName;
        this.queryParam = builder.queryParam;
    }

    public static class Builder{

        private String protocol;
        private String hostName;
        private String port;
        private String pathName;
        private String queryParam;

        public Builder protocol(String protocol){
            this.protocol = protocol;
            return this;
        }

        public Builder hostName(String hostName){
            this.hostName = hostName;
            return this;
        }

        public Builder port(String port){
            this.port = port;
            return this;
        }

        public Builder pathName(String pathName){
            this.pathName = pathName;
            return this;
        }

        public Builder queryParam(String queryParam){
            this.queryParam = queryParam;
            return this;
        }

        public UrlNew build() {
            return new UrlNew(this);
        }
    }
}
