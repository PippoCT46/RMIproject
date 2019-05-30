import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface {

    @Override
    public double getSum(double a, double b) throws RemoteException {
        return a+b;
    }

    public Server() throws RemoteException{
        // modifiche se non siamo in localhost
        // super(xxxx);
    }

    public static void main(String args[]){

        try {
            //System.setProperties("java.rmi.server.hostname","whitelodge.ns=.it");
            //Registry registry = LocateRegistry.getRegistry();

            ServerInterface server = new Server();
            //registry.bind("Calculator", server);
            Naming.rebind("Calculator",server);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
