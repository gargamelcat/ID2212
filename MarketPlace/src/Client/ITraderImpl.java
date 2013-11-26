package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Server.Item;
import Server.Trader;

public class ITraderImpl extends UnicastRemoteObject implements ITrader{

	protected ITraderImpl() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean notifySeller(Trader trader, Item item)
			throws RemoteException {
		System.out.println(trader.getName() + "sold following product: " + item.getName() + " for: " + item.getPrice());
		return false;
	}

	@Override
	public boolean notifyWish(Trader trader, Item item) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
