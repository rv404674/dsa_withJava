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
        UrlNew.Builder builder = new UrlNew.Builder();
        // NOTE: this is chaining is possible because we are returing builder itself.
        builder.protocol("http://").hostName("newswebsite:").port("443");
        UrlNew urlNew = builder.build();

        System.out.print(urlNew.protocol);
        System.out.print(urlNew.hostName);
        System.out.print(urlNew.port);
        System.out.println("/n");

        // Example 2
        UrlNew.Builder builderTwo = new UrlNew.Builder();
        builderTwo.protocol("http://").hostName("newswebsite2").pathName("/abc");
        UrlNew urlBuilderTwo = builderTwo.build();

        System.out.print(urlBuilderTwo.protocol);
        System.out.print(urlBuilderTwo.hostName);
        System.out.print(urlBuilderTwo.pathName);
    }
}
