package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class  PropertyUtil {
	public static Properties Property(String property)throws IOException{
FileInputStream fis=new FileInputStream("Browser.Properties");
Properties prop=new Properties();
prop.load(fis);
return prop;

}
}