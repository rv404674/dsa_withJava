package creational.builder.sudocode;

public class Demo {
    public static void main(String[] args) {
        URL url = new URL();
        url.setProtocol("http://");
        url.setHostName("rahul.com");
        url.setPort(":8080/");
        url.setPathName("company");

        System.out.println(url.getPathName());

        // Example 1 - Using Builder Pattern
        UrlBuilder.Builder builder = new UrlBuilder.Builder();
        // NOTE: this is chaining is possible because we are returing builder itself.
        builder.protocol("http://").hostName("newswebsite:").port("443");
        UrlBuilder urlBuilder = builder.build();

        System.out.print(urlBuilder.protocol);
        System.out.print(urlBuilder.hostName);
        System.out.print(urlBuilder.port);
        System.out.println("/n");

        // Example 2
        UrlBuilder.Builder builderTwo = new UrlBuilder.Builder();
        builderTwo.protocol("http://").hostName("newswebsite2").pathName("/abc");
        UrlBuilder urlBuilderTwo = builderTwo.build();

        System.out.print(urlBuilderTwo.protocol);
        System.out.print(urlBuilderTwo.hostName);
        System.out.print(urlBuilderTwo.pathName);
    }
}
