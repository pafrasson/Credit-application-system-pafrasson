package credit.application.system

import lombok.NoArgsConstructor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
@NoArgsConstructor
@SpringBootApplication
class CreditApplicationSystemApplication

fun main(args: Array<String>) {
	runApplication<CreditApplicationSystemApplication>(*args)
}
