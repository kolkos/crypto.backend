package nl.kolkos.crypto.telegram.bot.backend.configuration;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.configuration.security.HeaderInterceptor;
import nl.kolkos.crypto.telegram.bot.backend.model.PortfolioToken;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final PortfolioToken portfolioToken;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor(portfolioToken)).addPathPatterns("/portfolios/check*", "/wallets/*", "/transactions");
    }

}
