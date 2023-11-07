package vn.edu.fpt.onlinelearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import vn.edu.fpt.onlinelearning.entity.Dummy;
import vn.edu.fpt.onlinelearning.repository.DummyRepository;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		DummyRepository dummyRepository = context.getBean(DummyRepository.class);

		for (int i = 0; i < 10; i++) {
			dummyRepository.save(new Dummy((i + 1), "Dummy " + (i + 1)));
		}
	}

}
