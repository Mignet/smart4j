package com.v5ent.core.Import;

import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import com.v5ent.core.Import.bean.ImportModelDefinition;

/**
 * poi处理工具类
 * @author Administrator
 *
 */
public class PoiUtil {
	/**
	 * 获取单元格的值
	 * @param cell 单元格对象
	 * @return 单元格值
	 */
	public static Object getValue(Cell cell){
		
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				return null;
			case Cell.CELL_TYPE_BOOLEAN:
				return cell.getBooleanCellValue();
			case Cell.CELL_TYPE_ERROR:
				return cell.getErrorCellValue();
			case Cell.CELL_TYPE_FORMULA:
				return cell.getCellFormula();
			case Cell.CELL_TYPE_NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)){
					return cell.getDateCellValue();
				}else{
					return BigDecimal.valueOf(cell.getNumericCellValue()).toString();
				}
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			default:
				return cell.getStringCellValue();
			}
	}
	
	public static Object getValue(Cell cell,ImportModelDefinition modelDefinition){
		
			String type = modelDefinition.getDataType();
			
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					return null;
				case Cell.CELL_TYPE_BOOLEAN:
					return cell.getBooleanCellValue();
				case Cell.CELL_TYPE_ERROR:
					return cell.getErrorCellValue();
				case Cell.CELL_TYPE_FORMULA:
					return cell.getCellFormula();
				case Cell.CELL_TYPE_NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)){
						return cell.getDateCellValue();
					}else{
						double numericCellValue = cell.getNumericCellValue();
						if("BigDecimal".equalsIgnoreCase(type)){
							return BigDecimal.valueOf(numericCellValue).toString();
						}else if("int".equalsIgnoreCase(type)){
							return (int)numericCellValue;
						}else if("mobile".equalsIgnoreCase(type)){
							return String.valueOf((long)numericCellValue);
						}
					}
				case Cell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
				default:
					return cell.getStringCellValue();
				}
		}

}
