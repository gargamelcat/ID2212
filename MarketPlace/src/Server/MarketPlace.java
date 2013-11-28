package Server;
 
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
import Bank.BankImpl;
import Bank.IBank;
import Client.ITrader;
import Client.Trader;
 
@SuppressWarnings("serial")
public class MarketPlace extends UnicastRemoteObject implements IMarketPlace {
        // private List<ITrader> clientList = new ArrayList<>();
        private Map<ITrader, ArrayList<Item>> clientList = new HashMap<ITrader, ArrayList<Item>>();
        private Map<ITrader, ArrayList<Item>> wishList = new HashMap<ITrader, ArrayList<Item>>();
 
        private ArrayList<Item> itemList = new ArrayList<Item>();
    	IBank bank = new BankImpl("UBS");
 
        public MarketPlace() throws RemoteException, MalformedURLException {
                super();
                try {
                        LocateRegistry.getRegistry(1099).list();
                } catch (RemoteException e) {
                        LocateRegistry.createRegistry(1099);
                }
                Naming.rebind("rmi://localhost/marketPlace", this);
        		Naming.rebind("rmi://localhost/bank", bank);
        }
 
        public Set<ITrader> getClients() {
                return (clientList.keySet());
        }
 
        @Override
        public void registerTrader(ITrader trader) throws RemoteException {
                if (clientList.containsKey(trader)) {
                        throw new RemoteException("client already registered");
                }
                clientList.put(trader, null);
                System.out.println("trader registered: " + trader.getName());
                trader.notifySeller(new Item("beer", 1000));
        }
 
        @Override
        public void unregisterTrader(ITrader trader) throws RemoteException {
                if (!clientList.containsKey(trader)) {
                        throw new RemoteException("client not registered");
                }
                clientList.remove(trader);
        }
 
        @Override
        public void sellItem(ITrader trader, String itemName, Integer price)
                        throws RemoteException {
                // TODO Auto-generated method stub              System.out.println("Trader name is: " + trader.getName());
                Item temp = new Item(itemName, price);
                if (clientList.get(trader) == null) {
                        System.out.println("following item is in the shop now: " + itemName
                                        + "/" + price);
                        clientList.put(trader, new ArrayList<Item>());
                }
                clientList.get(trader).add(temp);
 
                notifyChangesToAllTraders();
        }
 
        @Override
        public void buyItem(ITrader trader, Item item) throws RemoteException {
                // TODO Auto-generated method stub
                ITrader seller = null;
                for (Entry<ITrader, ArrayList<Item>> tempMap : clientList.entrySet()) {
                        System.out.println("Iteration.");
                        if (tempMap.getValue() != null) {
                                for(int k = 0; k < tempMap.getValue().size(); k++) {
                                        if(tempMap.getValue().get(k).getName().equals(item.getName()))  {
                                                tempMap.getValue().remove(k);
                                                seller = tempMap.getKey();
                                        }
                                }
                        }
                }              
                notifyChangesToAllTraders();
        }
 
        @Override
        public void addWish(ITrader trader, String wish) throws RemoteException {
        	Item tempItem = new Item(wish, 0);
        	if (wishList.containsKey(trader)) {
                        wishList.get(trader).add(tempItem);
                }
                else {
                        ArrayList<Item> tempWishList = new ArrayList<Item>();
                        tempWishList.add(tempItem);
                        wishList.put(trader, tempWishList);            
                }
                       
        }
 
        @Override
        public ArrayList<Item> getItemList() throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("getItemlList called");
                if (clientList.values() == null) {
                        System.out.println("There is no items to buy");
                        return null;
                }
                ArrayList<Item> tempList = new ArrayList<Item>();
                for (ArrayList<Item> lista : clientList.values()) {
                        if (lista != null) {
                                tempList.addAll(lista);
                        }
                }
                return tempList;
        }
 
        private void notifyChangesToAllTraders() {
                for (Entry<ITrader, ArrayList<Item>> tempMap : clientList.entrySet()) {
                        try {
                                if (tempMap.getKey() != null) {
                                	System.out.println(tempMap.getKey().getName());
                                        tempMap.getKey().dataChanged();
                                }
                        } catch (RemoteException e) {
                                System.out.println("could not notify traders.");
                                e.printStackTrace();
                        }
                }
        }
}