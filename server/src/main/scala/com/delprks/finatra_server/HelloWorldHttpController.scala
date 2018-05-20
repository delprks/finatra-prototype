package com.delprks.finatra_server

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class HelloWorldHttpController extends Controller {

  get("/hi") { request: Request =>
    info("hi")
    "Hello " + request.params.getOrElse("name", "unnamed")
  }

  post("/hi") { hiRequest: HiRequest =>
    "Hello " + hiRequest.name + " with id " + hiRequest.id
  }
}
