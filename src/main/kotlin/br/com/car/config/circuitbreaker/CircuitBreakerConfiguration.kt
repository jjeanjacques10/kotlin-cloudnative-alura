package br.com.car.config.circuitbreaker

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class CircuitBreakerConfiguration {

    private fun getConfiguration() = CircuitBreakerConfig.custom()
            .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
            .slidingWindowSize(10) // A cada 10 chamadas, o circuito é aberto
            .slowCallRateThreshold(70.0f) // Se 70% das chamadas forem lentas, o circuito é aberto
            .failureRateThreshold(70.0f) // Se 70% das chamadas falharem, o circuito é aberto
            .waitDurationInOpenState(Duration.ofSeconds(5)) // O circuito fica aberto por 5 segundos
            .slowCallDurationThreshold(Duration.ofSeconds(2)) // Uma chamada é considerada lenta se demorar mais de 2 segundos
            .permittedNumberOfCallsInHalfOpenState(5) // O circuito fica meio aberto por 5 chamadas
            .build()

    fun getCircuitBreaker() = CircuitBreakerRegistry.of(getConfiguration())
            .circuitBreaker("circuit-breaker-car-service")
}