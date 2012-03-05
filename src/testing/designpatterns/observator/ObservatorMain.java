package testing.designpatterns.observator;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 03.03.12
 * Time: 11:32
 */

class Producer extends Observable {

    private int productNumber = 0;
    private String newProduct;

    public void createProduct() {
        newProduct = "Created product number " + String.valueOf(productNumber++);
        setChanged();
        //notifyObservers("New message");
        notifyObservers();
    }

    public String getNewProduct() {
        return newProduct;
    }
}

class Client implements Observer {

    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        Producer p = (Producer) o;
        String s = (String) arg;
        System.out.println(getName() + p.getNewProduct() + s);
    }

    public String getName() {
        return name;
    }
}

public class ObservatorMain {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Client client1 = new Client("First Client");
        Client client2 = new Client("Second Client");

        producer.addObserver(client1);
        producer.addObserver(client2);

        producer.createProduct();

    }
}
