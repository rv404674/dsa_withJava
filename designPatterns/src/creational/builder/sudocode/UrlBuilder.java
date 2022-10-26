package creational.builder.sudocode;

public class UrlBuilder {

    // NOTE: To use builder pattern
    // have an inner nested static class
    // same fields as URL
    // inner class Builder should also have constructoe for all field
    // with only exception that it will return Builder type
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

        public UrlBuilder build() {
            return new UrlBuilder(this);
        }
    }

    public final String protocol;
    public final String hostName;
    public final String port;
    public final String pathName;
    public final String queryParam;

    private UrlBuilder(Builder builder){
        this.protocol = builder.protocol;
        this.hostName = builder.hostName;
        this.port = builder.port;
        this.pathName = builder.pathName;
        this.queryParam = builder.queryParam;
    }
}
