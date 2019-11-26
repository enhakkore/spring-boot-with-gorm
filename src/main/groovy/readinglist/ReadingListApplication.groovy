package readinglist

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.method.support.HandlerMethodArgumnetResolver
import org.springframework.web.servlet.config.annotaion.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class ReadingListApplication extends WebMvcConfigurerAdapter {

	static void main(String[] args) {
		SpringApplication.run(ReadingListApplication, args)
	}

	@Override
	void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewControllers("/login").setViewName("login")
	}

	@Override
	void addArgumentResolvers(List<HandlerMethodArgumnetResolver> argumentResolvers) {
		argumentResolvers.add(new ReaderHandlerMethodArgumentResolver())
	}

}
