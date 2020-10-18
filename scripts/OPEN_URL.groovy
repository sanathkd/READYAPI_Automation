import javax.swing.JOptionPane;
import java.util.Arrays;

public class OPEN_URL {

    static final def browsers = [ "google-chrome", "firefox", "opera",
            "epiphany", "konqueror", "conkeror", "midori", "kazehakase", "mozilla"
            ] as String[];
    static final String errMsg = "Error attempting to launch web browser";

    public static void main(def args){
        openURL("https://www.google.co.in/")
    }

    public static void openURL(String url) {
        try {
//          attempt to use Desktop library from JDK 1.6+
//          code mimicks: java.awt.Desktop.getDesktop().browse()
            Class<?> d = Class.forName("java.awt.Desktop");
            d.getDeclaredMethod("browse", [java.net.URI.class] as
            Class[]).invoke(
                    d.getDeclaredMethod("getDesktop").invoke(null),
                    [java.net.URI.create(url)] as Object[] );
        }
        catch (Exception ignore) { 
//          When library not available or failed
            String osName = System.getProperty("os.name");
            try {
                if (osName.startsWith("Mac OS")) {
                    Class.forName("com.apple.eio.FileManager").getDeclaredMethod(
                            "openURL", [String.class] as Class[]).invoke(null,
                            [url] as Object[] );
                }
                else if (osName.startsWith("Windows"))
                    Runtime.getRuntime().exec(
                            "rundll32 url.dll,FileProtocolHandler " + url);
                else { 
//                  assume Unix or Linux
                    String browser = null;
                    for (String b : browsers)
                        if (browser == null && Runtime.getRuntime().exec(
                                ["which", b] as String[]).getInputStream().read() != -1)
                    Runtime.getRuntime().exec([browser = b, url] as
                    String[]);
                    if (browser == null)
                        throw new Exception(Arrays.toString(browsers));
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, errMsg + "\n" + e.toString());
            }
        }
    }
}