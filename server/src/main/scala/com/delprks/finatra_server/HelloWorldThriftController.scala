package com.delprks.finatra_server

import com.example.ping.thriftjava.Ping
import com.twitter.finatra.http.Controller
import com.twitter.util.Future

class HelloWorldThriftController extends Controller {

  override val myFunction = handle(Ping) { args: MyFunction.Args =>
    info(s"Adding numbers $args.a + $args.b")
    Future.value(args.a + args.b)
  }
}
