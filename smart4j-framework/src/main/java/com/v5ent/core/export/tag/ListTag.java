package com.v5ent.core.export.tag;

import org.apache.poi.ss.usermodel.Cell;

import com.v5ent.core.export.PoiTag;
import com.v5ent.core.export.bean.CellDefinition;

public class ListTag implements PoiTag{
	
	
	

	@Override
	public CellDefinition parse(Cell cell, String tag) {
		CellDefinition cellDefinition =null;
		if(tag.startsWith(NAME_PREFIX_START)){
			String[] values = tag.split(" ");
			if(values.length==4){
				cellDefinition = new CellDefinition(cell, values[3].substring(NAME_PREFIX.length(), values[3].length()-NAME_Suffix.length()), values[1]);
			}
		}
		return cellDefinition;
	}

}
