package com.my.quickstart.util;

import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Map.Entry;  
import javax.imageio.ImageIO;  
import javax.imageio.ImageReader;  
import javax.imageio.stream.ImageInputStream;  
    
public class FileType {
	
	public File file;
	
	public void setFile(File file) {
		if(!file.exists()) {
			this.file = null;
			
			return ;
		}
		
		this.file = file;
	}
	/**
	 * 用于获得图片类型
	 */
	public String fileType;
	
	public String getFileType() {
		return getImageFileType(this.file);
	}
	
	/**
	 * 图片分辨率
	 */
	public String resolution;
	
	public String getResolution() {
		BufferedImage sourceImg = null;
		try {
			sourceImg = ImageIO.read(new FileInputStream(this.file)); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		if(sourceImg == null) {
			return null;
		}
		
		 return sourceImg.getWidth()+"*"+sourceImg.getHeight(); 
	}
	
	public double size;
	
	public double getSize() {
		   
		return Arith.div(this.file.length(), 1024, 2);  
	}
	
	public String filePath;
	
	public String getFilePath() {
		return filePath;
		//return this.file.getPath().substring(file.getPath().lastIndexOf(File.separator+"public")).replace("\\", "/");
	}
	
	public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();    
    
//    private FileType(){} 
    
    static {    
        getAllFileType();  //初始化文件类型信息     
    }    
        
    /**  
     * <p>Discription:[getAllFileType,常见文件头信息]</p>  
     * @author:[shixing_11@sina.com]  
     */    
    private static void getAllFileType() {    
        FILE_TYPE_MAP.put("jpg", "FFD8FF"); //JPEG (jpg)     
        FILE_TYPE_MAP.put("png", "89504E47");  //PNG (png)     
        FILE_TYPE_MAP.put("gif", "47494638");  //GIF (gif)     
        FILE_TYPE_MAP.put("tif", "49492A00");  //TIFF (tif)     
        FILE_TYPE_MAP.put("bmp", "424D"); //Windows Bitmap (bmp)     
        FILE_TYPE_MAP.put("dwg", "41433130"); //CAD (dwg)     
        FILE_TYPE_MAP.put("html", "68746D6C3E");  //HTML (html)     
        FILE_TYPE_MAP.put("rtf", "7B5C727466");  //Rich Text Format (rtf)     
        FILE_TYPE_MAP.put("xml", "3C3F786D6C");    
        FILE_TYPE_MAP.put("zip", "504B0304");    
        FILE_TYPE_MAP.put("rar", "52617221");    
        FILE_TYPE_MAP.put("psd", "38425053");  //Photoshop (psd)     
        FILE_TYPE_MAP.put("eml", "44656C69766572792D646174653A");  //Email [thorough only] (eml)     
        FILE_TYPE_MAP.put("dbx", "CFAD12FEC5FD746F");  //Outlook Express (dbx)     
        FILE_TYPE_MAP.put("pst", "2142444E");  //Outlook (pst)     
        FILE_TYPE_MAP.put("xls", "D0CF11E0");  //MS Word     
        FILE_TYPE_MAP.put("doc", "D0CF11E0");  //MS Excel 注意：word 和 excel的文件头一样     
        FILE_TYPE_MAP.put("mdb", "5374616E64617264204A");  //MS Access (mdb)     
        FILE_TYPE_MAP.put("wpd", "FF575043"); //WordPerfect (wpd)      
        FILE_TYPE_MAP.put("eps", "252150532D41646F6265");    
        FILE_TYPE_MAP.put("ps", "252150532D41646F6265");    
        FILE_TYPE_MAP.put("pdf", "255044462D312E");  //Adobe Acrobat (pdf)     
        FILE_TYPE_MAP.put("qdf", "AC9EBD8F");  //Quicken (qdf)     
        FILE_TYPE_MAP.put("pwl", "E3828596");  //Windows Password (pwl)     
        FILE_TYPE_MAP.put("wav", "57415645");  //Wave (wav)     
        FILE_TYPE_MAP.put("avi", "41564920");    
        FILE_TYPE_MAP.put("ram", "2E7261FD");  //Real Audio (ram)     
        FILE_TYPE_MAP.put("rm", "2E524D46");  //Real Media (rm)     
        FILE_TYPE_MAP.put("mpg", "000001BA");  //     
        FILE_TYPE_MAP.put("mov", "6D6F6F76");  //Quicktime (mov)     
        FILE_TYPE_MAP.put("asf", "3026B2758E66CF11"); //Windows Media (asf)     
        FILE_TYPE_MAP.put("mid", "4D546864");  //MIDI (mid)     
    }    
    
    /**  
     * <p>Discription:[getImageFileType,获取图片文件实际类型,若不是图片则返回null]</p>  
     * @param File  
     * @return fileType  
     * @author:[shixing_11@sina.com]  
     */    
    public final static String getImageFileType(File f) {    
        if (isImage(f)) { 
        	
            try {  
                ImageInputStream iis = ImageIO.createImageInputStream(f);  
                Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
                
                if (!iter.hasNext())  {  
                    return null;  
                }  
                
                ImageReader reader = iter.next();  
                iis.close();  
                
                return reader.getFormatName();  
            }catch (IOException e) {  
                return null;  
            }catch (Exception e) {  
                return null;  
            }  
        }
        
        return null;  
    }    
    
    /**   
     * <p>Discription:[getFileByFile,获取文件类型,包括图片,若格式不是已配置的,则返回null]</p>  
     * @param file  
     * @return fileType  
     * @author:[shixing_11@sina.com]  
     */    
    public final static String getFileByFile(File file) {    
        String filetype = null;    
        byte[] b = new byte[50];
        
        try {    
            InputStream is = new FileInputStream(file);    
            is.read(b);    
            filetype = getFileTypeByStream(b);    
            is.close();    
        }catch (FileNotFoundException e) {    
            e.printStackTrace();    
        }catch (IOException e) {    
            e.printStackTrace();    
        } 
        
        return filetype;    
    }    
        
    /**   
     * <p>Discription:[getFileTypeByStream]</p>  
     * @param b  
     * @return fileType  
     * @author:[shixing_11@sina.com]  
     */    
    public final static String getFileTypeByStream(byte[] b) {    
        String filetypeHex = String.valueOf(getFileHexString(b));    
        Iterator<Entry<String, String>> entryiterator = FILE_TYPE_MAP.entrySet().iterator(); 
        
        while (entryiterator.hasNext()) {    
            Entry<String,String> entry =  entryiterator.next();    
            String fileTypeHexValue = entry.getValue(); 
            
            if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {    
                return entry.getKey();    
            }    
        } 
        
        return null;    
    }    
        
    /** 
     * <p>Discription:[isImage,判断文件是否为图片]</p> 
     * @param file 
     * @return true 是 | false 否 
     * @author:[shixing_11@sina.com] 
     */  
    public static final boolean isImage(File file) {  
    	String type = getFileNameExt(file.getName());
    	
    	if(type == null) {
    		return false;
    	}
    	
    	if (!"GIF,JPG,JPEG,PNG,BMP".contains(type.toUpperCase())) {
			return false;
		}
    	
        boolean flag = false;  
         
        try {  
            BufferedImage bufreader = ImageIO.read(file);  
            int width = bufreader.getWidth();  
            int height = bufreader.getHeight();  
            
            if(width==0 || height==0) {  
                flag = false;  
            }else {  
                flag = true;  
            }  
        }catch (IOException e) {  
            flag = false;  
        }catch (Exception e) {  
            flag = false;  
        }  
        
        return flag;  
    }  
      
    /**   
     * <p>Discription:[getFileHexString]</p>  
     * @param b  
     * @return fileTypeHex  
     * @author:[shixing_11@sina.com]  
     */    
    public static final String getFileHexString(byte[] b) {    
        StringBuilder stringBuilder = new StringBuilder();
        
        if (b == null || b.length <= 0) {    
            return null;    
        } 
        
        for (int i = 0; i < b.length; i++) {    
            int v = b[i] & 0xFF;    
            String hv = Integer.toHexString(v); 
            
            if (hv.length() < 2) {    
                stringBuilder.append(0);    
            }
            
            stringBuilder.append(hv);    
        }
        return stringBuilder.toString();    
    }
    
    public static final String getFileNameExt(String fileName) {
    	
		if(fileName==null || "".equals(fileName)){
			return null;
		}
		
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
    
}
