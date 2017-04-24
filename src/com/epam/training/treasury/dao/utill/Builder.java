package com.epam.training.treasury.dao.utill;

import java.util.List;

import com.epam.training.treasury.beans.Treasure;

public interface Builder {
	
	public Treasure initialization(Treasure treasure, List<String> content);

}
