import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Client {

    public static void main(String[] args) {

        String address = args[0];
        String servicename = args[1];

        if(args.length!=2){
            System.out.println("Usage: java Client <addredd> <servicename>");
            exit(-1);
        }

        try {
            ServerInterface server = (ServerInterface) Naming.lookup("rmi://" + address + "/" + servicename);
            Scanner input = new Scanner(System.in);
            System.out.println("Inserisci due numeri:");
            double n1 = input.nextDouble();
            double n2 = input.nextDouble();
            double sum = server.getSum(n1,n2);
            System.out.println("La somma è:" + sum);

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
