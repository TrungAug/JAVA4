package pc05132.lab4.bai4.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pc05132.lab4.bai4.entity.Item;


public class ItemDAO {
	
	List<Item> listItem = new ArrayList<>();
	public static ItemDAO getInstance() {
		return new ItemDAO();
	}

	public List<Item> myData() {
		listItem.add(new Item("Electric Vehicle", "https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png", 100,0.1,new Date()));
		listItem.add(new Item("Ventus V2 concept2", "https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png", 10,0.2,new Date()));
		listItem.add(new Item("Smart Flex DH35", "https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png", 900,0.1,new Date()));
		listItem.add(new Item("Electric Vehicle", "https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png", 200,0.1,new Date()));
		listItem.add(new Item("Passenger Car", "https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png", 210,0.2,new Date()));
		listItem.add(new Item("SUV", "https://asset.hankooktire.com/content/dam/hankooktire/eu/product/tire_list/suv/IH01A_normal.png", 300,0.1,new Date()));
		
		return listItem;
	}

	public List<Item> getAllItem() {
		return listItem;
	}
}
