package com.v5ent.core.Import.tag;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

import com.v5ent.core.Import.CellDefinition;
import com.v5ent.core.Import.PoiTag;



public class TitleTag implements PoiTag{

	@Override
	public CellDefinition parse(Cell cell, String tag) {
		CellDefinition cellDefinition =null;
		if(StringUtils.isNotBlank(tag)&&!tag.startsWith("#")&&!tag.startsWith(NAME_PREFIX)&&!tag.endsWith(NAME_Suffix)){
			cellDefinition = new CellDefinition(cell, tag);
		}
		return cellDefinition;
	}

}
