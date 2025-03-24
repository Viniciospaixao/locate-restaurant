package scala.com.lr.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class RestauranteSimulation extends Simulation {

  // Configuração do HTTP
  val httpProtocol = http
    .baseUrl("http://localhost:8080") // URL base da sua API
    .acceptHeader("application/json")

  // Cenário de teste
  val scn = scenario("Teste de Carga para Listar Restaurantes")
    .exec(
      http("Listar Restaurantes")
        .get("/restaurantes") // Endpoint da API
        .check(status.is(200)) // Verifica se o status da resposta é 200
    )

  // Configuração da simulação
  setUp(
    scn.inject(
      constantUsersPerSec(10) during (30.seconds) // 10 usuários por segundo durante 30 segundos
    )
  ).protocols(httpProtocol)
}