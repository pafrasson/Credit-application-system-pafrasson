package credit.application.system.exception

data class BussinessException(override val message: String?) : RuntimeException(message)
