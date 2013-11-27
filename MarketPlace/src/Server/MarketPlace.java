package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Client.ITrader;
import Client.Trader;

@SuppressWarnings("serial")
public class MarketPlace extends UnicastRemoteObject implements IMarketPlace
{
    private List<ITrader> clientList = new ArrayList<>();

    public MarketPlace() throws RemoteException, MalformedURLException
    {
        super();
        try
        {
            LocateRegistry.getRegistry(1099).list();
        } catch (RemoteException e)
        {
            LocateRegistry.createRegistry(1099);
        }
        Naming.rebind("rmi://localhost/marketPlace", this);
    }

    public List<ITrader> getClients()
    {
        return (clientList);
    }

	@Override
	public void registerTrader(ITrader trader) throws RemoteException {
        if (clientList.contains(trader))
        {
            throw new RemoteException("client already registered");
        }
        clientList.add(trader);
        System.out.println("trader registered: " + trader.getName());
        trader.notifySeller(new Item("beer", 1000));
    }

	@Override
	public void unregisterTrader(ITrader trader) throws RemoteException {
        boolean result = true;
		if (!clientList.contains(trader))
        {
            throw new RemoteException("client not registered");
        }
        clientList.remove(trader);
    }


	@Override
	public void sellItem(ITrader trader, Item item) throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public void buyItem(ITrader trader, Item item) throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public void addWish(ITrader trader, Item Item) throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Item> getItemList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}