package com.delprks.finatra_server

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class HelloWorldHttpController extends Controller {
case class ExampleCaseClass(
  id: String,
  description: String,
  longValue: Long,
  boolValue: Boolean)

  get("/hi") { request: Request =>
    "Hello World"
//    info("hi")
//    ExampleCaseClass(
//    id = "123",
//    description = "This is a JSON response body",
//    longValue = 1L,
//    boolValue = true)
  }

  post("/hi") { hiRequest: HiRequest =>
    "Hello " + hiRequest.name + " with id " + hiRequest.id
  }
}
