package doyle.sean.cubedraft;

import doyle.sean.cubedraft.model.Draft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CubeDraftApplication {

	public static Map<String, Draft> draftsAvailable = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(CubeDraftApplication.class, args);
	}
}
