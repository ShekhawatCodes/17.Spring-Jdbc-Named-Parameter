package in.sumit.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.sumit.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
    	NamedParameterJdbcTemplate namedParameterJdbcTemplate =  context.getBean(NamedParameterJdbcTemplate.class);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("key_name", "BHURIA");
    	map.put("key_rollno", 201);
    	map.put("key_marks", 77.2f);
    	
    	String insert_sql_query = "INSERT INTO student VALUES(:key_name,:key_rollno,:key_marks)";
    	int count = namedParameterJdbcTemplate.update(insert_sql_query, map);
    	
    	if(count>0) {
    		System.out.println("insert success");
    	}
    	else {
    		System.out.println("insert failed");
    	}
    }
}
