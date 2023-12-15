package unb.azul.hortencias.blog.feudal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BlogFeudalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogFeudalApplication.class, args);
	}

}
