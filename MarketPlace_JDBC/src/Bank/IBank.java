package Bank;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IBank extends Remote {
    public IAccount newAccount(String name) throws RemoteException, RejectedException;
    public IAccount getAccount(String name) throws RemoteException;
    public boolean deleteAccount(String name) throws RemoteException;
    public String[] listAccounts() throws RemoteException;
}
