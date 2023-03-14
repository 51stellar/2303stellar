package Demo;

import Demo.ReflectDemo.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    //建立用例编号与行的映射，返回结果列与列的映射
    public static Map<String,Integer> caseIdRownumMapping=new HashMap<String, Integer>();
    public static Map<String,Integer> cellNameCellnumMapping=new HashMap<String, Integer>();
    public static List<WriteBackData> writeBackDatas=new ArrayList<WriteBackData>();
    static{
        loadRownumAndCellnumMapping("src/main/resources/a_Reflect_case.xlsx","用例");
    }
//建立用例编号与行的映射，返回结果列与列的映射实现
    private static void loadRownumAndCellnumMapping(String excelPath, String sheetName) {
        InputStream inputStream=null;
        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(new File(excelPath));
            Sheet sheet=workbook.getSheet(sheetName);
            Row titleRow=sheet.getRow(0);
            if(titleRow!=null&&!isEmptyRow(titleRow)){
                int lastCellnum=titleRow.getLastCellNum();
                //循环处理标题的每一列
                for(int i=0;i<lastCellnum;i++){
                    Cell cell=titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String title=cell.getStringCellValue();
                    title=title.substring(0,title.indexOf("("));
                    int cellnum=cell.getAddress().getColumn();
                    cellNameCellnumMapping.put(title,cellnum);
                }
            }
            //从第二行开始，获取所有的数据行
            int lastRownum=sheet.getLastRowNum();
            //循环拿到数据行
            for(int i=1;i<lastRownum;i++){
                Row dataRow=sheet.getRow(i);
                Cell firstCellOfRow=dataRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                firstCellOfRow.setCellType(CellType.STRING);
                String caseId=firstCellOfRow.getStringCellValue();
                int rowNum=dataRow.getRowNum();
                caseIdRownumMapping.put(caseId,rowNum);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{

                try {
                    if(inputStream!=null) {
                        inputStream.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

        }

    }
    //根据用例编号映射行数，根据列名称映射列行，去把响应结果回写到excel中去
    public static void writeBackData(String excelPath,String sheetName,String caseId, String cellName, String result) {
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream=new FileInputStream(new File(excelPath));
            Workbook workbook=WorkbookFactory.create(inputStream);
            Sheet sheet=workbook.getSheet(sheetName);
            int rowNum=caseIdRownumMapping.get(caseId);
            Row row=sheet.getRow(rowNum);
            int cellNum=cellNameCellnumMapping.get(cellName);
            Cell cell=row.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(result);
            outputStream=new FileOutputStream(new File(excelPath));
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

                try {
                    if(outputStream!=null) {
                        outputStream.close();
                    }
                    if(inputStream!=null){
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }



    }








    //根据给定的起始行，起始列去获取数据
    public static Object[][] datas1(String url, int startRow, int endRow, int startCell, int endCell) {
        String excelPath = "src/main/resources/test1.xlsx";
        //获取workbook对象
        Workbook workbook = null;
        Object[][] data = new Object[endRow - startRow + 1][endCell - startCell + 1];
        try {
            workbook = WorkbookFactory.create(new File(excelPath));
            //获取sheet对象
            Sheet sheet = workbook.getSheet("用例");
            //获取行

            for (int i = startRow; i <= endRow; i++) {
                Row row = sheet.getRow(i);
                for (int j = startCell; j <= endCell; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    //将列设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    data[i - startRow][j - startCell] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return data;
    }

    //比如说取2，3，4,5,6行的6，7列数据
    public static Object[][] datas2(String url, String sheetName, int rows[], int cells[]) {
        //"src/main/resources/test1.xlsx"
        String excelPath = url;
        //获取workbook对象
        Workbook workbook = null;
        Object[][] data = new Object[rows.length][cells.length];
        try {
            workbook = WorkbookFactory.create(new File(excelPath));
            //获取sheet对象
            Sheet sheet = workbook.getSheet(sheetName);
            //获取行

            for (int i = 0; i < rows.length; i++) {
                Row row = sheet.getRow(rows[i] - 1);
                for (int j = 0; j < cells.length; j++) {
                    Cell cell = row.getCell(cells[j] - 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    //将列设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    data[i][j] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    //通过对象方式去封装取到的excel值
    //T代表泛型，不指定对象的类型
    public static <T> void load(String url, String sheetName, Class<T> clazz) {
        //获取workbook对象
        Workbook workbook = null;
        //反射声明
        try {
            workbook = WorkbookFactory.create(new File(url));
            //获取sheet对象
            Sheet sheet = workbook.getSheet(sheetName);
            //获取第一行也就是标题行
            Row titleRow = sheet.getRow(0);
            //获取最后一列的列号
            int lastCellNum = titleRow.getLastCellNum();
            //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            String[] fields = new String[lastCellNum];
            for (int i = 0; i < lastCellNum; i++) {
                Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                //根据"("分割获取属性值
                String cellValue = cell.getStringCellValue();
                cellValue = cellValue.substring(0, cellValue.indexOf("("));
                fields[i] = cellValue;
            }
            //获取最后一行的行索引值
            int lastRowIndex = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowIndex; i++) {
                Row row = sheet.getRow(i);
                //每行生成一个对象，存储每行数据
                Object obj = clazz.newInstance();
                if (row == null || isEmptyRow(row)) {
                    continue;
                }
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    //将列设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    //获取i行的j列数据值
                    String value = cell.getStringCellValue();
                    String methodName = "set" + fields[j];
                    //获取要反射的方法对象
                    Method method = clazz.getMethod(methodName, String.class);
                    method.invoke(obj, value);
                }
                if(obj instanceof Case){
                  Case cs=(Case)obj;
                  CaseUtil.cases.add(cs);
                }else if(obj instanceof Rest){
                    Rest rest=(Rest)obj;
                    RestUtil.rests.add(rest);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isEmptyRow(Row row) {
        int lastcellNum = row.getLastCellNum();
        for (int i = 0; i < lastcellNum; i++) {
            Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue();
            if (value != null && value.trim().length() > 0) {
                return false;
            }
        }
        return true;
    }


}
