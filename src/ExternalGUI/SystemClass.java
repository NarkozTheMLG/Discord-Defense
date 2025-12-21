package ExternalGUI;

import java.util.ArrayList;

import GameSystem.Items;

public class SystemClass {
	public static ArrayList<Integer> items = new ArrayList<Integer>(); 
	public static boolean add(int id) {
		if(items.size()==5)
			return false;
		items.add(id);
		return true;
	}
	public static boolean delete(int id) {
		if(search(id)) {
			items.remove(id);
			return true;
		}
		return false;
	}

	public static boolean search(int id) {
		for(Integer i: items)
			if(id == i)
				return true;
		return false;
	}
	
	public static Items display(int id) {
		for(Integer i : items)
			if( i == id && search(id)) {
				return new Items(id,-9);
			}
		return null;
	}
	public static Items[] display() {
		Items[] temp = new Items[items.size()];
		int count = 0;
		for(Integer i : items)
			temp[count++] = new Items(i,-9);
		return temp;
	}

}
