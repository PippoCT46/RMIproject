import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface {

    @Override
    public double getSum(double a, double b) throws RemoteException {
        return a+b;
    }

    public Server() throws RemoteException{

    }

    public static void main(String args[]){

        try {
            ServerInterface server = new Server();
            Naming.rebind("Calculator",server);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
