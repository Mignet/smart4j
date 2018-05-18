package com.v5ent.core.export.tag;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.StringUtils;

import com.v5ent.core.export.PoiTag;
import com.v5ent.core.export.bean.CellDefinition;


public class TitleTag implements PoiTag{

	@Override
	public CellDefinition parse(Cell cell, String tag) {
		CellDefinition cellDefinition =null;
		if(StringUtils.hasLength(tag)&&!tag.startsWith("#")&&!tag.startsWith(NAME_PREFIX)&&!tag.endsWith(NAME_Suffix)){
			cellDefinition = new CellDefinition(cell, tag);
		}
		return cellDefinition;
	}

}
