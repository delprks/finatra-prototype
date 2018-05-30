package com.delprks.finatra_server

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter

object HelloWorldServerMain extends HelloWorldServer

class HelloWorldServer extends HttpServer {

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[HelloWorldHttpController]
  }

//  override def configureThrift(router: ThriftRouter) = {
//    router
//      .filter[LoggingMDCFilter[Request, Response]]
//      .filter[TraceIdMDCFilter[Request, Response]]
//      .filter[CommonFilters]
//      .add[HelloWorldThriftController]
//  }
}
