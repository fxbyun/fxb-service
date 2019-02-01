package domain;

public interface ExtensionFeatures {
    String getFeatures();

    void setFeatures(String var1);

    int getFeaturesVersion();

    void setupFeature(String var1, String var2);

    void setupFeature(String var1, Object var2);

    void removeFeature(String var1);

    String getFeature(String var1);

    <T> T getFeature(String var1, Class<T> var2);
}
