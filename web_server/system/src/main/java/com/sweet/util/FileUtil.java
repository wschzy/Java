package com.sweet.util;
import java.io.Writer;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static void saveFile(String dirPath,String fileName,MultipartFile image) throws Exception {
		File dir = new File(dirPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir,fileName);
		delFile(dirPath,fileName);
		image.transferTo(file);
	}

	public static void main(String[] args) throws IOException{
		saveFileContent("D:\\a.html","xxxxx");
	}

	/**
	 *
	 * @param 文件地址
	 * @param 文件内容
	 * @throws IOException
	 */
	public static void saveFileContent(String path,String content) throws IOException{
		delFile(path);//删除文件
		File file =new File(path);
		file.createNewFile();//创建文件
		try(Writer out =new FileWriter(file);){
			out.write(content);//写入内容
		}
	}

	public static void delFile(String path){
		File file=new File(path);
		if(file.exists() && file.isFile())
			file.delete();
	}

	public static void delFile(String dir,String filename){
        File file=new File(dir+"/"+filename);
        if(file.exists() && file.isFile())
            file.delete();
    }
	
	public static byte[] getFile(String path) throws IOException{
		File file = new File(path);
        try(FileInputStream inputStream = new FileInputStream(file)){
        	return getFileBytes(inputStream);
        }
	}

	public static byte[] getDefaultImg() throws IOException  {
		//此方法打成jar包不可取
		/*File file = ResourceUtils.getFile("classpath:static/image.png");
    	return file.getPath();*/
    	ClassPathResource resource = new ClassPathResource("static/image.png");
    	try(InputStream inputStream = resource.getInputStream()){
    		return getFileBytes(inputStream);
    	}
	}
	
	public static byte[] getFileBytes(InputStream inputStream) throws IOException {
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes, 0, inputStream.available());
		return bytes;
	}
	
	public static byte[]  getAllImage(String picture,String rootDir) throws IOException {
		if(StringUtil.isEmpty(picture)) {
			return  getDefaultImg();//默认图片
		}else {
			return getFile(rootDir +  "\\" + picture);
		}
    }
}
