/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.ext.consul;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.ext.consul.Event
import io.vertx.ext.consul.MaintenanceOptions
import io.vertx.ext.consul.Check
import io.vertx.ext.consul.Service
import io.vertx.ext.consul.CheckOptions
import io.vertx.ext.consul.Coordinate
import io.vertx.ext.consul.KeyValue
import io.vertx.ext.consul.ServiceOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.ext.consul.Node
import io.vertx.ext.consul.BlockingQueryOptions
import io.vertx.ext.consul.CheckStatus
import io.vertx.groovy.core.Vertx
import java.util.List
import io.vertx.ext.consul.KeyValueOptions
import io.vertx.ext.consul.AclToken
import io.vertx.ext.consul.SessionOptions
import io.vertx.core.Handler
import io.vertx.ext.consul.DcCoordinates
import io.vertx.ext.consul.Session
import io.vertx.ext.consul.EventOptions
@CompileStatic
public class ConsulService extends ConsulClient {
  private final def io.vertx.ext.consul.ConsulService delegate;
  public ConsulService(Object delegate) {
    super((io.vertx.ext.consul.ConsulService) delegate);
    this.delegate = (io.vertx.ext.consul.ConsulService) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a proxy to a service that is deployed somewhere on the event bus
   * @param vertx the Vert.x instance
   * @param address the address the service is listening on on the event bus
   * @return the service
   */
  public static ConsulService createEventBusProxy(Vertx vertx, String address) {
    def ret = InternalHelper.safeCreate(io.vertx.ext.consul.ConsulService.createEventBusProxy(vertx != null ? (io.vertx.core.Vertx)vertx.getDelegate() : null, address), io.vertx.groovy.ext.consul.ConsulService.class);
    return ret;
  }
  public ConsulService agentInfo(Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).agentInfo(resultHandler != null ? new Handler<AsyncResult<io.vertx.core.json.JsonObject>>() {
      public void handle(AsyncResult<io.vertx.core.json.JsonObject> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService coordinateNodes(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).coordinateNodes(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Coordinate>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Coordinate>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService coordinateDatacenters(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).coordinateDatacenters(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.DcCoordinates>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.DcCoordinates>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService getValue(String key, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).getValue(key, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.KeyValue>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.KeyValue> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService getValueBlocking(String key, Map<String, Object> options, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).getValueBlocking(key, options != null ? new io.vertx.ext.consul.BlockingQueryOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(options)) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.KeyValue>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.KeyValue> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService deleteValue(String key, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).deleteValue(key, resultHandler);
    return this;
  }
  public ConsulService getValues(String keyPrefix, Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).getValues(keyPrefix, resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.KeyValue>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.KeyValue>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService getValuesBlocking(String keyPrefix, Map<String, Object> options, Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).getValuesBlocking(keyPrefix, options != null ? new io.vertx.ext.consul.BlockingQueryOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(options)) : null, resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.KeyValue>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.KeyValue>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService deleteValues(String keyPrefix, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).deleteValues(keyPrefix, resultHandler);
    return this;
  }
  public ConsulService putValue(String key, String value, Handler<AsyncResult<Boolean>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).putValue(key, value, resultHandler);
    return this;
  }
  public ConsulService putValueWithOptions(String key, String value, Map<String, Object> options, Handler<AsyncResult<Boolean>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).putValueWithOptions(key, value, options != null ? new io.vertx.ext.consul.KeyValueOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(options)) : null, resultHandler);
    return this;
  }
  public ConsulService createAclToken(Map<String, Object> token = [:], Handler<AsyncResult<String>> idHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).createAclToken(token != null ? new io.vertx.ext.consul.AclToken(io.vertx.lang.groovy.InternalHelper.toJsonObject(token)) : null, idHandler);
    return this;
  }
  public ConsulService updateAclToken(Map<String, Object> token = [:], Handler<AsyncResult<String>> idHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).updateAclToken(token != null ? new io.vertx.ext.consul.AclToken(io.vertx.lang.groovy.InternalHelper.toJsonObject(token)) : null, idHandler);
    return this;
  }
  public ConsulService cloneAclToken(String id, Handler<AsyncResult<String>> idHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).cloneAclToken(id, idHandler);
    return this;
  }
  public ConsulService listAclTokens(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).listAclTokens(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.AclToken>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.AclToken>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService infoAclToken(String id, Handler<AsyncResult<Map<String, Object>>> tokenHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).infoAclToken(id, tokenHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.AclToken>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.AclToken> ar) {
        if (ar.succeeded()) {
          tokenHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          tokenHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService destroyAclToken(String id, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).destroyAclToken(id, resultHandler);
    return this;
  }
  public ConsulService fireEvent(String name, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).fireEvent(name, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.Event>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.Event> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService fireEventWithOptions(String name, Map<String, Object> options, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).fireEventWithOptions(name, options != null ? new io.vertx.ext.consul.EventOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(options)) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.Event>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.Event> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService listEvents(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).listEvents(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Event>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Event>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService registerService(Map<String, Object> serviceOptions = [:], Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).registerService(serviceOptions != null ? new io.vertx.ext.consul.ServiceOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(serviceOptions)) : null, resultHandler);
    return this;
  }
  public ConsulService maintenanceService(Map<String, Object> maintenanceOptions = [:], Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).maintenanceService(maintenanceOptions != null ? new io.vertx.ext.consul.MaintenanceOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(maintenanceOptions)) : null, resultHandler);
    return this;
  }
  public ConsulService deregisterService(String id, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).deregisterService(id, resultHandler);
    return this;
  }
  public ConsulService catalogServiceNodes(String service, Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).catalogServiceNodes(service, resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Service>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Service>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService catalogServiceNodesWithTag(String service, String tag, Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).catalogServiceNodesWithTag(service, tag, resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Service>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Service>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService catalogDatacenters(Handler<AsyncResult<List<String>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).catalogDatacenters(resultHandler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService catalogNodes(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).catalogNodes(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Node>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Node>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService catalogServices(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).catalogServices(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Service>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Service>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService localServices(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).localServices(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Service>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Service>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService catalogNodeServices(String node, Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).catalogNodeServices(node, resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Service>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Service>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService localChecks(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).localChecks(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Check>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Check>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService registerCheck(Map<String, Object> checkOptions = [:], Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).registerCheck(checkOptions != null ? new io.vertx.ext.consul.CheckOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(checkOptions)) : null, resultHandler);
    return this;
  }
  public ConsulService deregisterCheck(String checkId, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).deregisterCheck(checkId, resultHandler);
    return this;
  }
  public ConsulService passCheck(String checkId, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).passCheck(checkId, resultHandler);
    return this;
  }
  public ConsulService passCheckWithNote(String checkId, String note, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).passCheckWithNote(checkId, note, resultHandler);
    return this;
  }
  public ConsulService warnCheck(String checkId, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).warnCheck(checkId, resultHandler);
    return this;
  }
  public ConsulService warnCheckWithNote(String checkId, String note, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).warnCheckWithNote(checkId, note, resultHandler);
    return this;
  }
  public ConsulService failCheck(String checkId, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).failCheck(checkId, resultHandler);
    return this;
  }
  public ConsulService failCheckWithNote(String checkId, String note, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).failCheckWithNote(checkId, note, resultHandler);
    return this;
  }
  public ConsulService updateCheck(String checkId, CheckStatus status, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).updateCheck(checkId, status, resultHandler);
    return this;
  }
  public ConsulService updateCheckWithNote(String checkId, CheckStatus status, String note, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).updateCheckWithNote(checkId, status, note, resultHandler);
    return this;
  }
  public ConsulService leaderStatus(Handler<AsyncResult<String>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).leaderStatus(resultHandler);
    return this;
  }
  public ConsulService peersStatus(Handler<AsyncResult<List<String>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).peersStatus(resultHandler != null ? new Handler<AsyncResult<java.util.List<java.lang.String>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.String>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService createSession(Handler<AsyncResult<String>> idHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).createSession(idHandler);
    return this;
  }
  public ConsulService createSessionWithOptions(Map<String, Object> options = [:], Handler<AsyncResult<String>> idHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).createSessionWithOptions(options != null ? new io.vertx.ext.consul.SessionOptions(io.vertx.lang.groovy.InternalHelper.toJsonObject(options)) : null, idHandler);
    return this;
  }
  public ConsulService infoSession(String id, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).infoSession(id, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.Session>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.Session> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService renewSession(String id, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).renewSession(id, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.consul.Session>>() {
      public void handle(AsyncResult<io.vertx.ext.consul.Session> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService listSessions(Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).listSessions(resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Session>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Session>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService listNodeSessions(String nodeId, Handler<AsyncResult<List<Map<String, Object>>>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).listNodeSessions(nodeId, resultHandler != null ? new Handler<AsyncResult<java.util.List<io.vertx.ext.consul.Session>>>() {
      public void handle(AsyncResult<java.util.List<io.vertx.ext.consul.Session>> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((List)ar.result()?.collect({(Map<String, Object>)InternalHelper.wrapObject(it?.toJson())})));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  public ConsulService destroySession(String id, Handler<AsyncResult<Void>> resultHandler) {
    ((io.vertx.ext.consul.ConsulService) delegate).destroySession(id, resultHandler);
    return this;
  }
  public void close() {
    ((io.vertx.ext.consul.ConsulService) delegate).close();
  }
}
