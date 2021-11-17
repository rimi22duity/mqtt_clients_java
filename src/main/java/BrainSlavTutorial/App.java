/**Reference:
 * https://www.youtube.com/watch?v=n-32wyp3k3U&t=339s */
package BrainSlavTutorial;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class App {

    public static MqttAsyncClient myClient;

    public static void main(String[] args) {
        String host = "";
        try {
            myClient = new MqttAsyncClient(host, UUID.randomUUID().toString());
            MyCallback myCallback = new MyCallback();
            myClient.setCallback(myCallback);

            IMqttToken token = myClient.connect();
            token.waitForCompletion();

            myClient.subscribe("yo_me", 0);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
