package org.thestrangeloop.couchbase

import com.couchbase.client.CouchbaseClient
import com.couchbase.client.protocol.views.Query
import grails.converters.JSON
import groovy.json.JsonSlurper

class UserController {
    CouchbaseClientService couchbaseClientService
    CouchbaseClient getCouchbaseClient() {
        couchbaseClientService.client
    }

    JsonSlurper getSlurper() {
        new JsonSlurper()
    }

    def index() {
        def view = couchbaseClient.getView('dev_test', 'test')
        def query = new Query(includeDocs: true)
        def response = couchbaseClient.query(view, query)
        def out = new StringWriter()
        def rows = []
        response.collect { row ->
            def doc = row.document
            if(doc instanceof String) {
                doc = slurper.parseText(doc)
            }
            rows << [key: row.id, doc: doc ]
        }
        [rows: rows]
    }

    def edit() {
        def key = params.id
        def labels = [
            'User Id': 'id',
            'User Name': 'user',
            'First Name': 'first',
            'Last Name': 'last',
            'Email Address': 'email',
            'Company Name': 'company'
        ]
        String doc = couchbaseClient.get(key)
        Map map = doc instanceof String ? slurper.parseText(doc) : doc
        map.keySet().each { String k ->
            if(!labels.values().contains(k)) {
                labels[k] = k
            }
        }
        [docKey: key, labels: labels, doc: map]
    }

    def save() {
        String key = params.id
        String old = couchbaseClient.get(key)
        def map = old instanceof String ? slurper.parseText(old) : doc
        params.each { k, v ->
            if(!['id', 'action', 'controller'].contains(k)) {
                map[k] = v
            }
        }
        couchbaseClient.set(key, (map as JSON).toString())
        redirect(uri: '/users')
    }
}
