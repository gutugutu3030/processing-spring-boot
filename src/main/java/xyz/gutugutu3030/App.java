package xyz.gutugutu3030;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import xyz.gutugutu3030.processing.DemoFrame;

@SpringBootApplication
public class App{

	public static void main(String[] args) {
        new SpringApplicationBuilder(App.class)
                .headless(false)
                .web(true)
                .run(args);
    }

    /**
     * Creates the {@link DemoFrame} object and returns it.
     *
     * This @Bean could have been replaced by a @Component annotation being
     * added to the {@link DemoFrame} class.
     *
     * @return the application window
     */
    @Bean
    public DemoFrame frame() {
        return new DemoFrame();
    }
}
