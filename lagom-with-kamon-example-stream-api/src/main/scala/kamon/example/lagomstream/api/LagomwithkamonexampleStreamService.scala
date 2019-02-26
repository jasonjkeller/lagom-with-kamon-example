package kamon.example.lagomstream.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The lagom-with-kamon-example stream interface.
  *
  * This describes everything that Lagom needs to know about how to serve and
  * consume the LagomwithkamonexampleStream service.
  */
trait LagomwithkamonexampleStreamService extends Service {

  def stream: ServiceCall[Source[String, NotUsed], Source[String, NotUsed]]

  override final def descriptor = {
    import Service._

    named("lagom-with-kamon-example-stream")
      .withCalls(
        namedCall("stream", stream)
      ).withAutoAcl(true)
  }
}

