package TraderGui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Server.Item;


public class ProductModel extends AbstractTableModel {

	private ArrayList<Item> itemList = null;

	public ProductModel() {
	}

	public ArrayList<Item> itemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return itemList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = null;
		int temp;
		
		switch(columnIndex){
		case 0:
			result = itemList.get(rowIndex).getName();
			break;
		case 1:
			result = Integer.toString(itemList.get(rowIndex).getPrice());
			break;
		default:
			throw new IllegalArgumentException(String.format("Column {0} does not exist", columnIndex));	
		}
		return result;
	}
	
    public String getColumnName(int column) {
        switch (column) {
        case 0:
            return "Product name";
        case 1:
            return "Price";
        default: 
            throw new IllegalArgumentException(String.format("Column {0} does not exist", column));
        }
    }	
}
